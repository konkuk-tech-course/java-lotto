package lotto.service;

import lotto.constant.LotteryRank;
import lotto.controller.LotteryController;
import lotto.domain.*;

import java.util.List;
import java.util.Map;

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

    public Map<LotteryRank, Integer> createResult(User user, WinningLottery winningLottery) {
        LotteryResult lotteryResult = new LotteryResult();
    }
}
