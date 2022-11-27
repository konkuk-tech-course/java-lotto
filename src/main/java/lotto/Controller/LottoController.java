package lotto.Controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView;
    OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.payMoney();
    }
}
