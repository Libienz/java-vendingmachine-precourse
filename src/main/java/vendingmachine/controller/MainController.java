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
        Coins coins = coinService.moneyToCoins(vendingMachineMoney);
        outputView.printVendingMachineCoins(CoinsDto.from(coins));

        Items items = doRepeat(inputView::readItems);


        Money inputMoney = doRepeat(inputView::readInputMoney);
        VendingMachine vendingMachine = new VendingMachine(coins, items, inputMoney);

        while (!vendingMachine.changeReturnCondition()) {
            outputView.printInputMoney(vendingMachine.getRemainMoney());
            doRepeat(() -> purchaseItem(vendingMachine, inputMoney));
        }

        outputView.printInputMoney(vendingMachine.getRemainMoney());
        Coins change = vendingMachine.getChange();
        outputView.printChanges(CoinsDto.from(change));
    }

    private Money purchaseItem(VendingMachine vendingMachine, Money inputMoney) {
        String itemName = inputView.readItemName();
        vendingMachine.purchaseItem(itemName);
        return inputMoney;
    }
}
