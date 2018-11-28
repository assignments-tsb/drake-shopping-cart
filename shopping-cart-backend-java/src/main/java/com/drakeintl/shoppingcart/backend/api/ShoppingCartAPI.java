package com.drakeintl.shoppingcart.backend.api;

import com.drakeintl.shoppingcart.backend.model.Item;
import com.drakeintl.shoppingcart.backend.model.Purchase;
import com.drakeintl.shoppingcart.backend.service.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class ShoppingCartAPI {

    private ShoppingCart shoppingCart;

    @RequestMapping(path = "shopping-cart/items", method = RequestMethod.GET)
    public List<Item> listAvailableItems() {
        return shoppingCart.listAvailableItems();
    }

    @SneakyThrows
    @RequestMapping(path = "shopping-cart/purchase", method = RequestMethod.POST)
    public List<Purchase> purchase(@RequestBody List<Purchase> purchases) {
        try {
            return shoppingCart.purchase(purchases);
        } catch (ShoppingCart.OrderFailure orderFailure) {
            orderFailure.printStackTrace();
            throw orderFailure;
        }
    }


}
