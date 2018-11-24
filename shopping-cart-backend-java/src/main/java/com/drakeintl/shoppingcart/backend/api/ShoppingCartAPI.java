package com.drakeintl.shoppingcart.backend.api;

import com.drakeintl.shoppingcart.backend.model.Item;
import com.drakeintl.shoppingcart.backend.service.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartAPI {

    @Autowired
    ShoppingCart shoppingCart;

    @RequestMapping(path = "shopping-cart", method = RequestMethod.GET)
    public List<Item> listAvailableItems() {
        return shoppingCart.listAvailableItems();
    }
}
