package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validate;

public class InputView {

    Validate validate = new Validate();
    OutputView outputView = new OutputView();
    public void payMoney() {
        try {
            String userMoney = Console.readLine();
            validate.validateUserMoney(userMoney);
        }catch(IllegalArgumentException e){
            outputView.printError(e.getMessage());
            payMoney();
        }
    }
}
