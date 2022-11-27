package lotto.controller;// @ author ninaaano

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run(){
        // 금액을 입력 받는다
        int money = InputValidator.isValidMoney(InputView.requestInputMoney()); // return money를 반환했다

        // 입력받은 금액만큼 로또를 발행한다
        OutputView.printLottoTicket(buyLotto(money));

        // 당첨 번호를 입력한다
        WinningNumber winningNumber = createWinningNumber();

        // 보너스 번호를 입력한다
        BonusNumber bonusNumber = createBonusNumber(winningNumber);


        // 당첨 내역을 출력한다

    }

    private LottoTicket buyLotto(int money){
        int count = LotteryCalculator.calculator(money);
        OutputView.printLottoNumber(count);
        return new LottoTicket(count);
    }

    private WinningNumber createWinningNumber(){
        return new WinningNumber(InputValidator.isValidNumber());
    } // retrurn 할때 이미 ,로 구분. 근데 입력받을때 ,안적어도 에러가 안난다???

    private BonusNumber createBonusNumber(WinningNumber winningNumber){
        return new BonusNumber(InputValidator.isValidBonusNumber(),winningNumber.getLottoNumbers());
    }


}
