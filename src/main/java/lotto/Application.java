package lotto;

import lotto.domain.*;
import lotto.enums.Announcement;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.print(Announcement.INPUT_MONEY_FOR_BUYING.getMessage());
        LottoBuyingMoney money = inputView.readMoney();

        LottoMaker lottoMaker = new LottoMaker();
        LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();
        List<Lotto> lottos = lottoMaker.makeLotto(lottoRandomNumberGenerator, money);
        outputView.print(money.convertBuyingCount() + Announcement.BUYING_COUNT_FORMAT.getMessage());
        outputView.printLottos(lottos);

        outputView.print(Announcement.INPUT_FIRST_LOTTO_NUMBERS.getMessage());
        FirstLotto firstLotto = inputView.readFirstLotto();
        outputView.print(Announcement.INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = inputView.readBonusNumber();

        LottoGame lottoGame = new LottoGame(lottos, firstLotto, bonusNumber);

        lottoGame.analyzeWinningResult();
        Analyst analyst = new Analyst(lottoGame);
        outputView.print(analyst.getReport());
    }
}
