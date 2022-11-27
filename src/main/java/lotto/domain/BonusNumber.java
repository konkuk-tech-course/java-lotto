package lotto.domain;

import java.util.List;
import lotto.Controller.LottoController;

public class BonusNumber {

    public static void validate(int bonusNumber){

        validateDuplicated(bonusNumber);
        validateSize(bonusNumber);
        validateInRange(bonusNumber);
    }

    private void validateDuplicated(int bonusNumber) {
        if (numbers.stream().distinct().count()!= numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에서는 중복된 숫자가 올 수 없습니다.");
        }
    }

    private void validateInRange(int bonusNumber) {
        if (numbers.stream().anyMatch(num -> 1 > num || 45 < num)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에서의 숫자 범위는 1-45사이입니다.");
        }
    }

}
