package lotto.domain;

import java.util.List;
import lotto.Controller.LottoController;

public class BonusNumber {

    public int validate(String bonusNumber){
        int convertedNumber = validateNumber(bonusNumber);
        validateDuplicated(convertedNumber);
        validateInRange(convertedNumber);
        return convertedNumber;
    }


    private int validateNumber(String bonusNumber){
        int bonus=0;
        try{
             bonus= Integer.parseInt(bonusNumber);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호에서는 숫자가 와야합니다.");
        }
        return bonus;
    }

    private void validateDuplicated(int bonusNumber) {
        if (WinningLotto.getWinningLottos().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에서는 중복된 숫자가 올 수 없습니다.");
        }
    }

    private void validateInRange(int bonusNumber) {
        if (1 > bonusNumber || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에서의 숫자 범위는 1-45사이입니다.");
        }
    }



}
