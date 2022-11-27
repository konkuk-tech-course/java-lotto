package lotto.domain;

import lotto.constant.ExceptionPhrase;

import java.util.List;

public class BonusNumber {

    public final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> list) {
        validate(bonusNumber);
        validate(bonusNumber, list);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ExceptionPhrase.범위외금지.getMessage());
        }
    }
    private void validate(int bonusNumber, List<Integer> list) {
        if(list.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionPhrase.보너스숫자로또숫자와겹치면안됨니다.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
