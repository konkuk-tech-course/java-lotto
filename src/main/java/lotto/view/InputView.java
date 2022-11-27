package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.InputPhrase;

public class InputView {
    private static InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public int readMoney() {
        System.out.println(InputPhrase.MONEY_INPUT.get());
        String moneyInput = Console.readLine();
        ViewValidator.validateNumberInput(moneyInput);
        return Integer.parseInt(moneyInput);
    }
}
