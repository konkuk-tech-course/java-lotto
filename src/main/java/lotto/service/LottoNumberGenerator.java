package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constant.LottoNumberProperties;

import java.util.List;

public class LottoNumberGenerator {
    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumberProperties.MIN_NUMBER.get(),
                LottoNumberProperties.MAX_NUMBER.get(),
                LottoNumberProperties.SIZE.get()
        );
    }
}
