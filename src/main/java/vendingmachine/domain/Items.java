package vendingmachine.domain;

import java.util.List;

public class Items {
    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean contains(String name) {
        return items.stream()
                .anyMatch(item -> name.equals(item.getName()));
    }
}
