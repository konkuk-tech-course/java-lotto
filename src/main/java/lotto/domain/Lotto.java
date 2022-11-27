package lotto.domain;

import lotto.enums.LottoTicketRule;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer number:
             numbers) {
            checkLottoNumberRange(number);
        }
    }
    private void checkLottoNumberRange(Integer number) {
        if (number < LottoTicketRule.LOWER_NUMBER.getRule() || LottoTicketRule.UPPER_NUMBER.getRule() < number) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
