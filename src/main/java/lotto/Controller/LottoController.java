package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningLotto;
import lotto.service.BonusNumber;
import lotto.service.Lotto;
import lotto.domain.AutoLotto;
import lotto.service.Calculated;
import lotto.domain.RankLogic;
import lotto.service.Validate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView;
    OutputView outputView;
    Validate validate =new Validate();
    Calculated calculated = new Calculated();
    AutoLotto autoLotto = new AutoLotto();
    RankLogic rankLogic = new RankLogic();
    WinningLotto winningLotto = new WinningLotto();
    BonusNumber bonusNum = new BonusNumber();
    static List<Integer> winningLottoTicket = new ArrayList<>();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int userMoney = payInput();
        List<Lotto> autoLottos = autoLotto.pickAutoLotto(calculated.lottoAmount(userMoney), outputView);
        winningLottoTicket = winningLottoTicket();
        int bonus = bonusInput();
        rankLogic.logicStart(autoLottos, winningLottoTicket, bonus);
        OutputView.printStatisTics(calculated.calculateYield(userMoney,RankLogic.rankMap));
    }



    public int payInput() {
        try {
            outputView.printPayMoney();
            String userMoney = inputView.payMoney();
            validate.validateUserMoney(userMoney);
        }catch(IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return payInput();
        }
        return validate.getConvertedUserMoney();
    }

    public List<Integer> winningLottoTicket() {
        outputView.printInputWinningLottoTicket();
        try {
            String winningLottoInput = inputView.winningLottoTicket();
            winningLottoTicket = winningLotto.settingWinningLottos(winningLottoInput);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return winningLottoTicket();
        }
        return winningLottoTicket;
    }


    public int bonusInput() {
        outputView.printBonusNumber();
        String bonus = inputView.bonusNumber();
        try{
           return bonusNum.validate(bonus);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return bonusInput();
        }
    }

}
