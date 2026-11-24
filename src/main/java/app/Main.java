package app;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Задание 1: Создание потоков");
        Thread evenThread = new EvenThread();
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();

        evenThread.join();
        oddThread.join();
        System.out.println("\nЗадание 1 завершено.\n");

        // Задание 2
        Task2Main.run();

        Thread.sleep(2000);

        // Задание 3
        Task3Main.run();
    }
}