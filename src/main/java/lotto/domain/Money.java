package lotto.domain;

import lotto.domain.constant.DomainErrorMessage;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (DomainValidator.isMoneyZero(money)) {
            throw new IllegalArgumentException(DomainErrorMessage.NO_MONEY.get());
        }

        if (!DomainValidator.isMultiplyOfCorrectUnit(money)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_UNIT.get());
        }
    }

    public int getMoney() {
        return money;
    }
}
