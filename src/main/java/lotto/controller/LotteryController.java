package lotto.controller;

import lotto.view.InputView;

public class LotteryController {
    private static LotteryController instance = new LotteryController();

    private LotteryController() {
    }

    public static LotteryController getInstance() {
        return instance;
    }
}
