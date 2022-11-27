package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 사용자의 금액은 숫자로만 입력될 수 있습니다. ");
        }
        return convertedUserMoney;
    }

    private static void validateThousandUnit(int convertedUserMoney) {
        if(convertedUserMoney % 1000 >0){
            throw new IllegalArgumentException("[ERROR] 사용자의 금액은 1000원 단위로만 올 수 있습니다.");
        }
    }

    public int validateNumber(String number){
        int convertNumber=0;
        try{
            convertNumber = Integer.parseInt(number);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 숫자 형태로만 올 수 있습니다.");
        }
        return convertNumber;
    }
}
