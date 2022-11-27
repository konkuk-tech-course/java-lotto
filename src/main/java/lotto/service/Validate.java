package lotto.service;

import lotto.constant.GameException;

public class Validate {

    private static int convertedUserMoney;
    public int validateUserMoney(String userMoney) {
        int convertedUserMoney = convertedUserMoney(userMoney);
        validateThousandUnit(convertedUserMoney);
        return convertedUserMoney;
    }

    public int getConvertedUserMoney() {
        return convertedUserMoney;
    }

    private static int convertedUserMoney(String userMoney) {
        try {
             convertedUserMoney = Integer.parseInt(userMoney);
        }catch (Exception e){
            throw new IllegalArgumentException(GameException.ERROR_USER_MONEY.message());
        }
        return convertedUserMoney;
    }

    private static void validateThousandUnit(int convertedUserMoney) {
        if(convertedUserMoney % 1000 >0){
            throw new IllegalArgumentException(GameException.ERROR_USER_MONEY_UNIT.message());
        }
    }

    public int validateNumber(String number){
        int convertNumber=0;
        try{
            convertNumber = Integer.parseInt(number);
        }catch (Exception e){
            throw new IllegalArgumentException(GameException.ERROR_LOTTO_NUMBER.message());
        }
        return convertNumber;
    }
}
