package com.drakeintl.shoppingcart.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    Long id;
    Long itemId;
    Integer quantity;
}
