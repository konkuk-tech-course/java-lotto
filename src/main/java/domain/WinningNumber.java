package domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return new Lotto(winningNumbers);
    }

    public WinningNumber() {
        winningNumbers = new ArrayList<>();
    }
}
