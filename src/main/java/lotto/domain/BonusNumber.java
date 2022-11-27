package lotto.domain;

import lotto.domain.constant.DomainErrorMessage;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (DomainValidator.isInvalidRange(number)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_RANGE_BONUS_NUMBER.get());
        }
    }
}
