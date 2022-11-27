package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMaker {
    public List<Lotto> makeLotto(LottoRandomNumberGenerator lottoRandomNumberGenerator, LottoBuyingMoney money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < money.convertBuyingCount(); index++) {
            Lotto lotto = new Lotto(lottoRandomNumberGenerator.generate()
                                                              .stream().sorted().collect(Collectors.toList()));
            lottos.add(lotto);
        }
        return lottos;
    }

}
