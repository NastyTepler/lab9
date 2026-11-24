package app;

import java.util.LinkedList;
import java.util.Queue;

public class ShoeWarehouse {
    public static final String[] SHOE_TYPES = {"Nike", "Adidas", "Puma", "Reebok"};

    private final Queue<Order> orders = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void receiveOrder(Order order) throws InterruptedException {
        while (orders.size() >= capacity) {
            wait();
        }
        orders.add(order);
        System.out.println("Поступил: " + order);
        notifyAll();
    }

    public synchronized Order fulfillOrder() throws InterruptedException {
        while (orders.isEmpty()) {
            wait();
        }
        Order order = orders.poll();
        System.out.println("Обработан: " + order);
        notifyAll();
        return order;
    }
}