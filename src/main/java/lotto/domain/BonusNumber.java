package lotto.domain;

import java.util.List;
import lotto.Controller.LottoController;

public class BonusNumber {

    public void validate(int bonusNumber){
        validateDuplicated(bonusNumber);
        validateInRange(bonusNumber);
    }

    private void validateDuplicated(int bonusNumber) {
        if (LottoController.getWinningLottoTicket().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에서는 중복된 숫자가 올 수 없습니다.");
        }
    }

    private void validateInRange(int bonusNumber) {
        if (1 > bonusNumber || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에서의 숫자 범위는 1-45사이입니다.");
        }
    }

}
