package app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ShoeWarehouseExecutor {
    public static final String[] SHOE_TYPES = {"Nike", "Adidas", "Puma", "Reebok"};

    private final BlockingQueue<Order> orders = new LinkedBlockingQueue<>(5);

    public void receiveOrder(Order order) throws InterruptedException {
        while (!orders.offer(order, 100, TimeUnit.MILLISECONDS)) {
            System.out.println("Склад полон, ждем...");
        }
        System.out.println("Поступил (Executor): " + order);
    }

    public Order fulfillOrder() throws InterruptedException {
        Order order = orders.take();
        System.out.println("Обработан (Executor): " + order);
        return order;
    }
}