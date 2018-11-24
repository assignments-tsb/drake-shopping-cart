package com.drakeintl.shoppingcart.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    Long id;
    String name;
    Integer quantity;
}
