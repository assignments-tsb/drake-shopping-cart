package com.drakeintl.shoppingcart.backend.model;

import lombok.Builder;
import lombok.Data;

/**
 * a request to buy an item
 */
@Data
@Builder
public class Purchase {

    Long id;
    Long itemId;
    Integer quantity;
}
