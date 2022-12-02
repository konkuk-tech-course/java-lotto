package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.service.BonusNumber;
import lotto.service.Validate;
import lotto.domain.WinningLotto;

public class InputView {

    public String payMoney() {
      return Console.readLine();
    }

    public String winningLottoTicket() {
        return Console.readLine();
    }


    public String bonusNumber() {
       return Console.readLine();
    }
}
