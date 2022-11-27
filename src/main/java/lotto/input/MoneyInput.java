package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validation;

public class MoneyInput implements Input<Integer>{

    private final Validation moneyValidation;

    public MoneyInput() {
        this.moneyValidation = new Validation();
    }

    @Override
    public String inputNumbers() {
        return Console.readLine();
    }

    @Override
    public Integer parseInt(String numbers) {
        moneyValidation.parseValidation(numbers);
        return Integer.parseInt(numbers);
    }
}
