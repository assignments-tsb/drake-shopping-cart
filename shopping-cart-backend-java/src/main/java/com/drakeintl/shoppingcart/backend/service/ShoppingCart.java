package com.drakeintl.shoppingcart.backend.service;

import com.drakeintl.shoppingcart.backend.model.Item;
import com.drakeintl.shoppingcart.backend.model.Order;

import java.util.List;

public class ShoppingCart {

    List<Item> listAvailableItems() {
        return null;
    }

    List<Order> purchase(List<Order> orders) throws OrderFailure {
        return null;
    }

    public class OrderFailure extends Exception {}
}
