package app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task3Main {
    public static void run() throws InterruptedException {
        System.out.println("\nЗадание 3: Producer-Consumer (ExecutorService)");
        ShoeWarehouseExecutor warehouse = new ShoeWarehouseExecutor();
        int totalOrders = 10;

        ExecutorService producerPool = Executors.newSingleThreadExecutor();
        ExecutorService consumerPool = Executors.newFixedThreadPool(2);

        producerPool.submit(() -> {
            for (int i = 1; i <= totalOrders; i++) {
                try {
                    Order order = new Order(i, ShoeWarehouseExecutor.SHOE_TYPES[i % 4], i);
                    warehouse.receiveOrder(order);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        for (int c = 0; c < 2; c++) {
            consumerPool.submit(() -> {
                for (int i = 0; i < 5; i++) {
                    try {
                        warehouse.fulfillOrder();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        producerPool.shutdown();
        consumerPool.shutdown();

        producerPool.awaitTermination(5, TimeUnit.SECONDS);
        consumerPool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Все заказы в ExecutorService обработаны.");
    }
}