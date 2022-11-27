package lotto.service;

import lotto.controller.LotteryController;

public class LotteryService {
    private static LotteryService instance = new LotteryService();

    private LotteryService() {
    }

    public static LotteryService getInstance() {
        return instance;
    }
    
}
