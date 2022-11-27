package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoTicketRule;

import java.util.List;

public class LottoRandomNumberGenerator implements LottoNumberGenerator{
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoTicketRule.LOWER_NUMBER.getRule(),
                LottoTicketRule.UPPER_NUMBER.getRule(),
                LottoTicketRule.NUMBERS_COUNT.getRule()
        );
    }
}
