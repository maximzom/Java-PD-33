package org.example.order.storage;

import org.example.order.processing.OrderProcessor;
import org.example.order.processing.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {
    private final List<OrderProcessor<? extends Product>> orders = new ArrayList<>();

    public void addOrder(OrderProcessor<? extends Product> order) {
        if (order != null) {
            orders.add(order);
        } else {
            System.out.println("Attempted to add a null order. Skipping.");
        }
    }

    public void processAllOrders() {
        orders.forEach(order -> {
            if (order != null) {
                order.process();
            } else {
                System.out.println("Encountered a null order, skipping processing.");
            }
        });
    }
}
