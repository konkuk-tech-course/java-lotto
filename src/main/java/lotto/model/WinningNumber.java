package lotto.model;// @ author ninaaano

import java.util.List;

public class WinningNumber {

    private final List<Integer> lottoNumbers;

    public WinningNumber(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
