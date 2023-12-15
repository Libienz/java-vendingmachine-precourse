package vendingmachine.domain;

public class Item {
    private final String name;
    private final Price price;
    private int quantity;

    public Item(String name, Price price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void sale() {
        quantity--;
    }
}
