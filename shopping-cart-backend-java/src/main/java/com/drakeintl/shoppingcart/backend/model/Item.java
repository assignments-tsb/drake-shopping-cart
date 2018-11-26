package com.drakeintl.shoppingcart.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * an item currently for sale
 */
@Data
@Builder
@NoArgsConstructor // framework needs this
@AllArgsConstructor
public class Item {

    Long id;
    String name;
    Integer quantity;
}
