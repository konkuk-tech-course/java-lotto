package lotto.domain;

import lotto.domain.constant.DomainErrorMessage;
import lotto.domain.constant.LottoNumberProperties;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (DomainValidator.isIncorrectSize(numbers)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_SIZE.get());
        }

        if (DomainValidator.hasInvalidRangeNumber(numbers)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_RANGE.get());
        }

        if (DomainValidator.hasSameNumber(numbers, LottoNumberProperties.SIZE.get())) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATED_NUMBERS.get());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
