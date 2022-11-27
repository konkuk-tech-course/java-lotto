package lotto.view;// @ author ninaaano

import lotto.model.constant.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public InputView() {
    }

    /**
     * 사용자의 금액을 입력받는다
     */
    public static String requestInputMoney(){
        System.out.println(InputMessage.REQUEST_INPUT_MONEY);
        return readLine();
    }

    /**
     * 사용자의 로또 번호를 입력 받는다
     */
    public static String requestInputLottoNumber(){
        System.out.println(InputMessage.REQUEST_INPUT_LOTTO_NUMBER);
        return readLine();
    }

    /**
     * 사용자의 보너스 번호를 입력 받는다
     */
    public static String requestInputBonusNumber(){
        System.out.println(InputMessage.REQUEST_BONUS_NUMBER);
        return readLine();
    }

}
