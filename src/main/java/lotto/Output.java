package lotto;

import lotto.constant.LottoPhrase;
import lotto.constant.PrintProfitRate;
import lotto.constant.ProfitRate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Output {

    public void printMoney() {
        System.out.println(LottoPhrase.구입금액을_입력해_주세요.getPhrase());
    }

    public void printCount(int count) {
        System.out.println(count + LottoPhrase.개를_구매했습니다.getPhrase());
    }

    public void printLottoNumber() {
        System.out.println(LottoPhrase.당첨_번호를_입력해주세요.getPhrase());
    }

    public void printBonusNumber() {
        System.out.println(LottoPhrase.보너스_번호를_입력해주세요.getPhrase());
    }
    public void printRewardRate() {
        System.out.println(LottoPhrase.당첨_통계.getPhrase());
    }

    public void printLottos(List<List<Integer>> list) {
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public void printPrize(Map<Integer, Integer>map) {
        System.out.println(PrintProfitRate.RATE.calc(map));
    }

    public void printRate(double rate) {
        System.out.println(ProfitRate.RATE.print(rate));
    }

}
