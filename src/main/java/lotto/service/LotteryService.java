package lotto.service;

import lotto.controller.LotteryController;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningLottery;

import java.util.List;

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

    public WinningLottery draw(List<Integer> numbers, int bonusNumber) {
        Lotto winningNumbers = new Lotto(numbers);
        BonusNumber bonus = new BonusNumber(bonusNumber);
        return new WinningLottery(bonus, winningNumbers);
    }
}
