package vendingmachine.view;

import vendingmachine.dto.CoinsDto;

public class MessageResolver {

    private String resolveVendingMachineMoneyInputMessage() {
        return "자판기가 보유하고 있는 금액을 입력해 주세요.";
    }
    public String resolveInputAmount(int money) {
        return "투입 금액: " + formatPrice(money);
    }

    public String resolveVendingMachineCoinsMessage(CoinsDto coinsDto) {
        return "자판기가 보유한 동전\n" + resolveCoinsMessage(coinsDto);
    }
    public String resolveChangeMessage(CoinsDto coinsDto) {
        return "잔돈\n" + resolveExistCoinsMessage(coinsDto);
    }
    private String formatPrice(int value) {
        return String.format("%d원", value);
    }

    private String formatCount(int count) {
        return String.format("%d개", count);
    }

    private String resolveCoinsMessage(CoinsDto coinsDto) {
        StringBuilder messageBuilder = new StringBuilder();
        coinsDto.getCoinValueCountMap().forEach((coinValue, count) ->
                messageBuilder.append(formatPrice(coinValue)).append(" - ").append(formatCount(count)).append("\n")
        );
        return messageBuilder.toString();
    }

    private String resolveExistCoinsMessage(CoinsDto coinsDto) {
        StringBuilder messageBuilder = new StringBuilder();
        coinsDto.getCoinValueCountMap()
                .forEach((coinValue, count) -> {
                    if (count > 0) {
                        messageBuilder.append(formatPrice(coinValue)).append(" - ").append(formatCount(count)).append("\n");
                    }
                });
        return messageBuilder.toString();
    }
}
