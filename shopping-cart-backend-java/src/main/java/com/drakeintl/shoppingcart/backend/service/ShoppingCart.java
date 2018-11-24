package com.drakeintl.shoppingcart.backend.service;

import com.drakeintl.shoppingcart.backend.model.Item;
import com.drakeintl.shoppingcart.backend.model.Order;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShoppingCart {

    public List<Item> listAvailableItems() {
        return Collections.singletonList(Item.builder()
                .id(1L)
                .name("Test")
                .quantity(20)
                .build());
    }

    public List<Order> purchase(List<Order> orders) throws OrderFailure {
        return null;
    }

    public class OrderFailure extends Exception {}
}
