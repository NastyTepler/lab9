package app;

public class OddRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println("OddRunnable (Нечетное): " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }
    }
}