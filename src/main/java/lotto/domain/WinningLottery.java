package lotto.domain;

import lotto.domain.constant.DomainErrorMessage;
import lotto.domain.constant.LottoProperties;

import java.util.ArrayList;
import java.util.List;

public class WinningLottery {
    private BonusNumber bonusNumber;
    private Lotto winningNumbers;

    public WinningLottery(BonusNumber bonusNumber, Lotto winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }
}
