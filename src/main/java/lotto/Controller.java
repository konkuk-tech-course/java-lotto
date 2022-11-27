package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Publish;
import lotto.input.BonusNumberInput;
import lotto.input.Input;
import lotto.input.LottoInput;
import lotto.input.MoneyInput;
import lotto.service.matchNumbers.MatchNumbers;
import lotto.service.matchNumbers.MatchNumbersImpl;
import lotto.service.profitRate.ProfitRate;
import lotto.service.profitRate.ProfitRateImpl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Controller {
    private final Input<Integer> moneyInput;
    private final Input<List<Integer>> lottoInput;
    private final BonusNumberInput bonusNumber;
    private Money money;
    private final Output output;
    private Publish publish;
    private Lotto lotto;
    private BonusNumber bonus;
    private final MatchNumbers matchNumbers;
    private final ProfitRate profitRate;

    public Controller() {
        this.matchNumbers = new MatchNumbersImpl();
        this.bonusNumber = new BonusNumberInput();
        this.lottoInput = new LottoInput();
        this.moneyInput = new MoneyInput();
        this.output = new Output();
        this.profitRate = new ProfitRateImpl();

    }

    void play() {
        output.printMoney();
        String input = moneyInput.inputNumbers();
        int inputMoney = moneyInput.parseInt(input);

        money = new Money(inputMoney);
        int count = money.count(inputMoney);
        output.printCount(count);

        publish = new Publish(count);

        List<List<Integer>> list = publish.publishNumbers(count);

        output.printLottos(list);

        output.printLottoNumber();
        String lottos = lottoInput.inputNumbers();
        List<Integer> inputLottos = lottoInput.parseInt(lottos);

        lotto = new Lotto(inputLottos);

        output.printBonusNumber();
        String bonusInput = bonusNumber.inputNumbers();
        int inputBonus = bonusNumber.parseInt(bonusInput);

        bonus = new BonusNumber(inputBonus);

        Map<Integer, Integer> map = matchNumbers.calculateRank(list, lotto.getNumbers(), bonus.getBonusNumber());
        int sum = profitRate.calculateTotalProfit(map);

        double rate = profitRate.calculateProfitRate(sum, money.getMoney());

        output.printPrize(map);
        output.printRate(rate);

    }




}
