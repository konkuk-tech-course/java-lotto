package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.Validate;
import lotto.domain.WinningLotto;

public class InputView {

    Validate validate = new Validate();
    OutputView outputView = new OutputView();

    WinningLotto win = new WinningLotto();

    List<Integer> winningLottoTicket = new ArrayList<>();

    public int payMoney() {
        try {
            outputView.printPayMoney();
            String userMoney = Console.readLine();
            validate.validateUserMoney(userMoney);
        }catch(IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return payMoney();
        }
        return validate.getConvertedUserMoney();
    }

    public List<Integer> winningLottoTicket() { // 역할 분리 꼭 해야됨
        outputView.printInputWinningLottoTicket();
        try {
            String winningLotto = Console.readLine();
            winningLottoTicket = win.settingWinningLottos(winningLotto);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return winningLottoTicket();
        }
        return winningLottoTicket;
    }



    public int bonusNumber() {
        try{
            String bonus = Console.readLine();
            int bonusNum = Integer.parseInt(bonus);
            BonusNumber.validate(bonusNum);

        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
        }
    }
}
