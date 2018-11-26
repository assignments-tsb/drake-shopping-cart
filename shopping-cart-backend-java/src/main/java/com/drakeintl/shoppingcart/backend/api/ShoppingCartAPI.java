package com.drakeintl.shoppingcart.backend.api;

import com.drakeintl.shoppingcart.backend.model.Item;
import com.drakeintl.shoppingcart.backend.model.Purchase;
import com.drakeintl.shoppingcart.backend.service.ShoppingCart;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ShoppingCartAPI {

    private ShoppingCart shoppingCart;

    @RequestMapping(path = "shopping-cart/items", method = RequestMethod.GET)
    public List<Item> listAvailableItems() {
        return shoppingCart.listAvailableItems();
    }

    @RequestMapping(path = "shopping-cart/purchase", method = RequestMethod.POST)
    public List<Purchase> purchase(@RequestBody List<Purchase> purchases) {
        try {
            return shoppingCart.purchase(purchases);
        } catch (ShoppingCart.OrderFailure orderFailure) {
            orderFailure.printStackTrace();
        }
        return null;
    }


}
