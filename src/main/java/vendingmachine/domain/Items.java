package vendingmachine.domain;

public class Items {
    private final String name;
    private final Price price;
    private final int quantity;

    public Items(String name, Price price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
