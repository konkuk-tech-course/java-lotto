package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validation;

public class BonusNumberInput implements Input<Integer>{

    private final Validation bonusNumbersValidation;

    public BonusNumberInput() {
        this.bonusNumbersValidation = new Validation();
    }

    @Override
    public String inputNumbers() {
        return Console.readLine();
    }

    @Override
    public Integer parseInt(String numbers) {
        bonusNumbersValidation.parseValidation(numbers);
        return Integer.parseInt(numbers);
    }
}
