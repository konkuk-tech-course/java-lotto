package lotto.domain;

public class BonusNumber {

    public final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
