package lotto.domain;

import lotto.domain.constant.DomainErrorMessage;
import lotto.domain.constant.LottoProperties;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isIncorrectSize(numbers)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_SIZE.get());
        }

        if (hasInvalidRangeNumber(numbers)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_RANGE.get());
        }

        if (hasSameNumber(numbers)) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATED_NUMBERS.get());
        }
    }

    private boolean isIncorrectSize(List<Integer> numbers) {
        return numbers.size() != LottoProperties.SIZE.get();

    }

    private boolean hasInvalidRangeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isInvalidRange);
    }

    private boolean isInvalidRange(int number) {
        return number < LottoProperties.MIN_NUMBER.get()
                && number > LottoProperties.MAX_NUMBER.get();
    }

    private boolean hasSameNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != LottoProperties.SIZE.get();
    }
}
