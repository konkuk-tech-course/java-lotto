package lotto.model;// @ author ninaaano

import lotto.model.constant.InputValidMessage;

import static lotto.model.constant.CommonCostants.IS_NUMBER;
import static lotto.model.constant.CommonCostants.MIN_LOTTO_PRICE;

public class InputValidator {

    public InputValidator() {
    }

    public static boolean isValidMoney(String inputMoney){
        try {
            isCheckNumber(inputMoney);
            int money = Integer.parseInt(inputMoney);
            amoutRange(money);
            return true;
        }catch (IllegalArgumentException e) {
            System.out.println(InputValidMessage.INPUT_MONEY_ERROR);
            return false;
        }
    }

    private static void amoutRange(int money) throws IllegalArgumentException{
        if(money < MIN_LOTTO_PRICE || (money % MIN_LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(InputValidMessage.INPUT_MONEY_ERROR.get());
        }
    }

    private static void isCheckNumber(String input) throws IllegalArgumentException{
        if(input == null || input.isBlank() || !input.matches(IS_NUMBER)){
            throw new IllegalArgumentException(InputValidMessage.INPUT_NUMBER_ERROR.get());
        }
    }
}
