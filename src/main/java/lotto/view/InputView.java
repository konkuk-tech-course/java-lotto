package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.Validate;

public class InputView {

    Validate validate = new Validate();
    OutputView outputView = new OutputView();
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




}
