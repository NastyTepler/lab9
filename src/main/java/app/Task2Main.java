package app;

public class Task2Main {
    public static void run() {
        System.out.println("Задание 2: Producer-Consumer (ручные потоки)");
        ShoeWarehouse warehouse = new ShoeWarehouse();
        int totalOrders = 10;

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= totalOrders; i++) {
                try {
                    Order order = new Order(i, ShoeWarehouse.SHOE_TYPES[i % 4], i);
                    warehouse.receiveOrder(order);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    warehouse.fulfillOrder();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    warehouse.fulfillOrder();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}