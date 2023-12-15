package vendingmachine.controller;

import static vendingmachine.util.Repeater.*;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.dto.CoinsDto;
import vendingmachine.service.CoinService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CoinService coinService;

    public MainController(InputView inputView, OutputView outputView, CoinService coinService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.coinService = coinService;
    }

    public void run() {
        Money vendingMachineMoney = doRepeat(inputView::readVendingMachineMoney);
        Items items = doRepeat(inputView::readItems);
        Coins coins = coinService.moneyToCoins(vendingMachineMoney);
        VendingMachine vendingMachine = new VendingMachine(coins, items, vendingMachineMoney);

        Money inputMoney = doRepeat(inputView::readInputMoney);
        while (vendingMachine.isMoneyCanAffordAtLeastOneItem(inputMoney)) {
            doRepeat(() -> purchaseItem(vendingMachine, inputMoney));
        }

        Coins change = vendingMachine.getChange();
        outputView.printChanges(CoinsDto.from(change));
    }

    private Money purchaseItem(VendingMachine vendingMachine, Money inputMoney) {
        String itemName = inputView.readItemName();
        vendingMachine.purchaseItem(inputMoney, itemName);
        return inputMoney;
    }
}
