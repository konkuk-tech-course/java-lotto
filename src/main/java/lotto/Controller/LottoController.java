package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.service.Lotto;
import lotto.domain.AutoLotto;
import lotto.domain.Calculated;
import lotto.domain.RankLogic;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView;
    OutputView outputView;
    Calculated calculated = new Calculated();
    AutoLotto autoLotto = new AutoLotto();
    RankLogic rankLogic = new RankLogic();
    static List<Integer> winningLottoTicket = new ArrayList<>();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int userMoney = inputView.payMoney();
        List<Lotto> autoLottos = autoLotto.pickAutoLotto(calculated.lottoAmount(userMoney));
        winningLottoTicket = inputView.winningLottoTicket();
        int bonus = inputView.bonusNumber();
        rankLogic.logicStart(autoLottos, winningLottoTicket, bonus);
        OutputView.printStatisTics(calculated.calculateYield(userMoney,RankLogic.rankMap));
    }

}
