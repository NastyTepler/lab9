package app;

public class Order {
    private final int id;
    private final String shoeType;
    private final int quantity;

    public Order(int id, String shoeType, int quantity) {
        this.id = id;
        this.shoeType = shoeType;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Заказ #" + id + " [" + shoeType + ", " + quantity + " шт.]";
    }
}