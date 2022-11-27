package lotto.service;

import lotto.controller.LotteryController;
import lotto.domain.Lotto;
import lotto.domain.User;

public class LotteryService {
    private static LotteryService instance = new LotteryService();

    private LotteryService() {
    }

    public static LotteryService getInstance() {
        return instance;
    }

    public User sellTickets(User user) {
        while (user.hasMoney()) {
            Lotto ticket = createTicket();
            user.buyTicket(ticket);
        }
        return user;
    }

    private Lotto createTicket() {
        return new Lotto(LottoNumberGenerator.generate());
    }
}
