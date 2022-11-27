package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.InputPhrase;

import javax.swing.text.View;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";

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

    public List<Integer> readWinningNumbers() {
        System.out.println(InputPhrase.WINNING_NUMBER_INPUT.get());
        String winningNumberInput = Console.readLine();
        List<String> parsedWinningNumberInput = parseWinningNumberInput(winningNumberInput);
        ViewValidator.validateWinningNumberInput(parsedWinningNumberInput);
        return parseToInteger(parsedWinningNumberInput);
    }

    private List<String> parseWinningNumberInput(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<Integer> parseToInteger(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int readBonusNumber() {
        System.out.println(InputPhrase.BONUS_NUMBER_INPUT.get());
        String bonusNumberInput = Console.readLine();
        ViewValidator.validateNumberInput(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }
}
