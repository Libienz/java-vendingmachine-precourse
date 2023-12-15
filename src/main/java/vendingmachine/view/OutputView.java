package vendingmachine.view;

import vendingmachine.dto.CoinsDto;

public class OutputView {
    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printVendingMachineCoins(CoinsDto coinsDto) {
        System.out.println(messageResolver.resolveVendingMachineCoinsMessage(coinsDto));
    }

    public void printChanges(CoinsDto coinsDto) {
        System.out.println(messageResolver.resolveChangeMessage(coinsDto));
    }
}
