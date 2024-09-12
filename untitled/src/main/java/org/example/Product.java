package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    @Override
    public String toString() {
        return "Товар{" +
                "id=" + id +
                ", Назва:'" + name + '\'' +
                ", Ціна:" + price +
                ", Опис:'" + description + '\'' +
                ", Категорія:'" + category.getName() + '\'' +
                '}';
    }
}
