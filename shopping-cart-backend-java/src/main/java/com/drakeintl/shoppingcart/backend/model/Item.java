package com.drakeintl.shoppingcart.backend.model;

import lombok.Builder;
import lombok.Data;

/**
 * an item currently for sale
 */
@Data
@Builder
public class Item {

    Long id;
    String name;
    Integer quantity;
}
