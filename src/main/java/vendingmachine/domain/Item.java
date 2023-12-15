package vendingmachine.domain;

public class Item {
    private final String name;
    private final Price price;
    private final int quantity;

    public Item(String name, Price price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
