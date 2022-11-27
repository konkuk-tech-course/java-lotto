package lotto.view;

import lotto.domain.FirstLotto;
import lotto.domain.LottoBuyingMoney;
import lotto.enums.LottoTicketRule;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public LottoBuyingMoney readMoney() {
        while (true) {
            try {
                String input = readLine().trim();
//                validate();
                return new LottoBuyingMoney(Integer.parseInt(input));
            } catch (IllegalArgumentException illegalArgumentException) {
                throw new IllegalArgumentException();
            }
        }
    }

    public FirstLotto readFirstLotto() {
        while (true) {
            try {
                String input = readLine().trim();
//                validate();
                return new FirstLotto(convertIntegerList(input));
            } catch (IllegalArgumentException illegalArgumentException) {
                throw new IllegalArgumentException();
            }
        }
    }
    private List<Integer> convertIntegerList(String input) {
        String[] stringArray = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : stringArray) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;

    }

    public int readBonusNumber() {
        while (true) {
            try {
                String input = readLine().trim();
                validateLottoNumberRange(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException illegalArgumentException) {
                throw new IllegalArgumentException();
            }
        }
    }
    private void validateLottoNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < LottoTicketRule.LOWER_NUMBER.getRule() || LottoTicketRule.UPPER_NUMBER.getRule() < number) {
            throw new IllegalArgumentException();
        }
    }
}
