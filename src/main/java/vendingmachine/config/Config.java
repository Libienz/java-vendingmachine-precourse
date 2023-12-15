package vendingmachine.config;

import vendingmachine.controller.MainController;
import vendingmachine.service.CoinService;
import vendingmachine.view.InputMapper;
import vendingmachine.view.InputView;
import vendingmachine.view.MessageResolver;
import vendingmachine.view.OutputView;

public class Config {
    public InputView inputView() {
        return new InputView(inputMapper(), messageResolver());
    }

    public OutputView outputView() {
        return new OutputView(messageResolver());
    }

    public InputMapper inputMapper() {
        return new InputMapper();
    }

    public MessageResolver messageResolver() {
        return new MessageResolver();
    }

    public MainController mainController() {
        return new MainController(inputView(), outputView(), coinService());
    }

    public CoinService coinService() {
        return new CoinService();
    }
}
