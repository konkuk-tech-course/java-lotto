package lotto.service;
import lotto.constant.GameException;
import lotto.domain.WinningLotto;

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
            throw new IllegalArgumentException(GameException.ERROR_BONUS_NUMBER.message());
        }
        return bonus;
    }

    private void validateDuplicated(int bonusNumber) {
        if (WinningLotto.getWinningLottos().contains(bonusNumber)) {
            throw new IllegalArgumentException(GameException.ERROR_BONUS_DUPLICATE.message());
        }
    }

    private void validateInRange(int bonusNumber) {
        if (1 > bonusNumber || 45 < bonusNumber) {
            throw new IllegalArgumentException(GameException.ERROR_BONUS_RANGE.message());
        }
    }



}
