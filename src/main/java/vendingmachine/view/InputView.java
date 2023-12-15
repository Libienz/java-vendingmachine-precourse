package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;

public class InputView {
    private final InputMapper inputMapper;
    private final MessageResolver messageResolver;

    public InputView(InputMapper inputMapper, MessageResolver messageResolver) {
        this.inputMapper = inputMapper;
        this.messageResolver = messageResolver;
    }

    public Money readVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return inputMapper.mapToMoney(Console.readLine());
    }

    public Items readItems() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return inputMapper.mapToItems(Console.readLine());
    }

    public Money readInputMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        return inputMapper.mapToMoney(Console.readLine());
    }

    public String readItemName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }
}
