package view;

import domain.LottoGenerator;
import lotto.Lotto;

import java.util.List;

public class OutputView {

    public void printLottery(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        List<Lotto> lottos = lottoGenerator.generateLotto();
        lottos.forEach(System.out::println);

    }
}
