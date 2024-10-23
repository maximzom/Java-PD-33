package org.example.order.management;

import com.github.javafaker.Faker;
import org.example.order.processing.Clothing;
import org.example.order.processing.OrderProcessor;
import org.example.order.storage.OrderStorage;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        OrderProcessor<Electronics> electronicsOrder = new OrderProcessor<>(new Electronics("Mobile phone"));
//        OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(new Clothing("Trousers"));
//
//        clothingOrder.process();
//        electronicsOrder.process();
//
//        clothingOrder.startProcessing();
//        electronicsOrder.startProcessing();

        var faker = new Faker();
        var clothing = Clothing.builder()
                .name(faker.beer().name())
                .price(Double.parseDouble(faker.commerce().price().replace(",",".")))
                .description(faker.beer().name())
                .build();
        OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(clothing);
        clothingOrder.process();
        clothingOrder.startProcessing();

        var clothingList  = IntStream.range(0, 1000).mapToObj(i -> Clothing.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                        .description(faker.lebowski().quote())
                        .build())
                .toList();
        clothingList.parallelStream()
                .map(OrderProcessor::new)
                .forEach(OrderProcessor::startProcessing);

        OrderStorage orderStorage = new OrderStorage();

        clothingList.forEach(clothingItem -> {
            if (clothingItem != null) {
                OrderProcessor<Clothing> order = new OrderProcessor<>(clothingItem);
                orderStorage.addOrder(order);
            }
        });

        orderStorage.processAllOrders();
    }
}
