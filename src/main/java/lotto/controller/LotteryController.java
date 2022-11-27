package lotto.controller;

import lotto.domain.Money;
import lotto.domain.User;
import lotto.service.LotteryService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LotteryController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    private static final LotteryService lotteryService = LotteryService.getInstance();

    private static LotteryController instance = new LotteryController();

    private LotteryController() {
    }

    public static LotteryController getInstance() {
        return instance;
    }

    public User createUser() {
        int moneyInput = requestNumberInput(inputView::readMoney);
        Money money = new Money(moneyInput);
        return new User("id", money);
    }

    private int requestNumberInput(Supplier<Integer> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return requestNumberInput(supplier);
        }
    }

    public User purchaseTicket(User user) {
        lotteryService.sellTickets(user);
        outputView.printPurchasedTickets(user.createTicketsInfo());
        return user;
    }
}
