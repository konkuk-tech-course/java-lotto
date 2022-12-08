package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public WinningNumber() {
        winningNumbers = new ArrayList<>();

    }
}
