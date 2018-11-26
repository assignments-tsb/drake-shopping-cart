package com.drakeintl.shoppingcart.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * a request to buy an item
 */
@Data
@Builder
@NoArgsConstructor // framework needs this
@AllArgsConstructor
public class Purchase {

    Long id;
    Long itemId;
    Integer quantity;
}
