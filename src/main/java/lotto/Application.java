package lotto;

import controller.LotteryGameController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        LotteryGameController controller = new LotteryGameController(input, output);
        controller.playTheGame();
    }
}
