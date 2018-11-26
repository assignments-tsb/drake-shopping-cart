package com.drakeintl.shoppingcart.backend.service;

import com.drakeintl.shoppingcart.backend.model.Item;
import com.drakeintl.shoppingcart.backend.model.Purchase;
import com.drakeintl.shoppingcart.backend.repository.ItemRepository;
import com.drakeintl.shoppingcart.backend.repository.PurchaseRepository;
import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ShoppingCart {

    private ItemRepository itemRepository;
    private PurchaseRepository purchaseRepository;

    public List<Item> listAvailableItems() {
        return itemRepository.findAll();
    }

    /**
     *
     * @param purchases the request to buy items
     * @return
     * @throws OrderFailure if the order is invalid
     */
    //@Transactional
    //on a real implementation this should be wrapped inside a transaction
    public List<Purchase> purchase(List<Purchase> purchases) throws OrderFailure {
        log.info("Purchasing Items: {}", purchases);
        Preconditions.checkNotNull(purchases);

        List<Long> itemIds = purchases.stream().map(Purchase::getItemId).collect(Collectors.toList());

        Map<Long,Item> items = itemRepository.find(itemIds).stream()
                .collect(Collectors.toMap(Item::getId, Function.identity()));

        for (Purchase purchase : purchases) {
            Item item = items.get(purchase.getItemId());

            if (item == null || item.getQuantity() < purchase.getQuantity()) {
                throw new OrderFailure();
            }

            item.setQuantity(item.getQuantity() - purchase.getQuantity());
        }

        //update the inventory
        itemRepository.save(items.values());

        return purchaseRepository.save(purchases);
    }

    //on a real implementation there should be more information inside this class
    //like the type of error, some message...etc.
    public class OrderFailure extends Exception {}
}
