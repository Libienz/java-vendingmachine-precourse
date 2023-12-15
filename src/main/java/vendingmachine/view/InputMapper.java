package vendingmachine.view;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.domain.Price;

public class InputMapper {
    private static final String NON_NUMERIC_VALUE_INPUT_MESSAGE = "[ERROR] 입력이 숫자가 아닙니다";
    private static final String INVALID_ITEMS_INPUT_FORM_MESSAGE = "[ERROR] 상품 목록 입력 형식이 잘못되었습니다";
    public Money mapToMoney(String input) {
        validateNumericValue(input);
        return new Money(Integer.parseInt(input));
    }

    public Items mapToItems(String input) {
        validateItemsInputForm(input);
        List<Item> items = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\[(.+?),([1-9]\\d*0),([0-9]+?)\\]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String name = matcher.group(1);
            Price price = new Price(Integer.parseInt(matcher.group(2)));
            int quantity = Integer.parseInt(matcher.group(3));
            items.add(new Item(name, price, quantity));
        }

        return new Items(items);
    }
    private void validateNumericValue(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_VALUE_INPUT_MESSAGE);
        }
    }

    private void validateItemsInputForm(String input) {
        if (!isItemsFormValid(input)) {
            throw new IllegalArgumentException(INVALID_ITEMS_INPUT_FORM_MESSAGE);
        }
    }

    private boolean isItemsFormValid(String input) {
        String regex = "\\[(.+?),([1-9]\\d*0),([0-9]+?)\\](;\\[(.+?),([1-9]\\d*0),([0-9]+?)\\])*";
        return Pattern.matches(regex, input);
    }
}
