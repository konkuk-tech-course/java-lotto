package lotto.domain;

import lotto.constant.LotteryRank;
import lotto.domain.constant.DomainErrorMessage;
import lotto.domain.constant.LottoProperties;

import java.util.ArrayList;
import java.util.List;

public class WinningLottery {
    private BonusNumber bonusNumber;
    private Lotto winningNumbers;

    public WinningLottery(BonusNumber bonusNumber, Lotto winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    private void validate(BonusNumber bonusNumber, Lotto winningNumbers) {
        List<Integer> numbersIncludingBonus = createNumberListIncludingBonus(bonusNumber, winningNumbers);
        if (DomainValidator.hasSameNumber(numbersIncludingBonus, LottoProperties.SIZE_WITH_BONUS_NUMBER.get())) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATE_NUMBERS_WITH_BONUS.get());
        }
    }

    private List<Integer> createNumberListIncludingBonus(BonusNumber bonusNumber, Lotto winningNumbers) {
        List<Integer> numbersIncludingBonus = new ArrayList<>(winningNumbers.getNumbers());
        numbersIncludingBonus.add(bonusNumber.getNumber());
        return numbersIncludingBonus;
    }

    public LotteryRank evaluate(List<Integer> lotteryNumbers) {
        int numberOfMatches = calculateNumberOfMatches(lotteryNumbers);
        boolean hasBonusNumber = containsBonusNumber(lotteryNumbers);
        return LotteryRank.find(numberOfMatches, hasBonusNumber);
    }

    private int calculateNumberOfMatches(List<Integer> lotteryNumbers) {
        return (int) lotteryNumbers.stream().filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private boolean containsBonusNumber(List<Integer> lotteryNumbers) {
        return lotteryNumbers.contains(bonusNumber.getNumber());
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }
}
