package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Util;

public class InputView {
    public static final int UNIT = 1_000;

    public int readMoney() {
        int money = Util.convertStringToInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    private void validateMoney(int money) {
        checkUnit(money % UNIT);
    }

    private void checkUnit(int remainder) {
        if (remainder != 0 ) throw new IllegalArgumentException("[ERROR] 1,000 단위로 입력해야 합니다.");
    }
}
