package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers.forEach(InputValidator::validateLottoNumber);
        InputValidator.validLottoNumberSize(numbers);
        InputValidator.validDuplicate(numbers);
        this.numbers = numbers;
    }


    public boolean contains(int lottoNumber) {
        return getLottoNumber().contains(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return new ArrayList<>(numbers);
    }

    public int countMatchedNumbers(List<Integer> winningNumbers) {
        return (int) this.numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    // 내보내기
   // public LottoNumbersDTO export() {
//        return new LottoNumbersDTO(numbers);
//    }

}
