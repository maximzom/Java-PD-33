package org.example.order.processing;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private String name;
    private Double price;
    private String description;
}
