package lotto.domain;

public class Validate {

    public void validateUserMoney(String userMoney) {

        int convertedUserMoney = getConvertedUserMoney(userMoney);
        validateThousandUnit(convertedUserMoney);

    }

    private static int getConvertedUserMoney(String userMoney) {
        int convertedUserMoney = 0;
        try {
             convertedUserMoney = Integer.parseInt(userMoney);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 사용자의 금액은 숫자로만 입력될 수 있습니다. ")
        }
        return convertedUserMoney;
    }

    private static void validateThousandUnit(int convertedUserMoney) {
        if(convertedUserMoney % 1000 >0){
            throw new IllegalArgumentException("[ERROR] 사용자의 금액은 1000원 단위로만 올 수 있습니다.")
        }
    }
}
