package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    public void printError(String message) {
        System.out.println(message);
    }



    public void printAutoLotto(List<Integer> pickLotto) {
        System.out.println(pickLotto);
    }

    public void printPayMoney() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void printInputWinningLottoTicket() {
        System.out.println("당첨 번호를 입력해주세요.");
    }
}
