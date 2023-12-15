package vendingmachine.domain;

import java.util.Comparator;
import java.util.List;

public class Items {
    private static final String NO_SUCH_ITEM_MESSAGE = "[ERROR] 해당하는 상품을 찾을 수 없습니다";
    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItem(String name) {
        return items.stream()
                .filter(item -> name.equals(item.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_ITEM_MESSAGE));
    }

    public Price cheapestPrice() {
        return items.stream()
                .filter(item -> item.getQuantity() > 0)
                .min(Comparator.comparingInt(item -> item.getPrice().getAmount()))
                .map(Item::getPrice)
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_ITEM_MESSAGE));
    }

    public boolean hasNoItem() {
        return items.stream()
                .allMatch(item -> item.getQuantity() == 0);
    }
}
