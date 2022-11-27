package lotto.model;// @ author ninaaano

import lotto.model.constant.InputValidMessage;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import static lotto.model.constant.CommonCostants.IS_NUMBER;
import static lotto.model.constant.CommonCostants.MIN_LOTTO_PRICE;

public class InputValidator {

    public InputValidator() {
    }

    /**
     * 입력받은 로또 번호 유효성 검사
     */
    public static boolean isValidNumber(String inputNumber){
        try {
            isCheckNumber(inputNumber);
            int number = Integer.parseInt(inputNumber);
            validateLottoNumber(number);
            return true;
        }catch (IllegalArgumentException e) {
            System.out.println(InputValidMessage.INPUT_NUMBER_ERROR);
            return false;
        }
    }

    public static void validateLottoNumber(int number) {
        if(!checkRange(number)) {
            System.out.println("로또 번호는 1 ~ 45 사이의 번호여야 합니다.");
            throw new IllegalArgumentException(InputValidMessage.AMOUNT_RANGE.get());
        }
    }
    public static boolean checkRange(int number){
        return number >= 1 && number <= 45;
    }

    public static void isValidBonusNumber(Lotto lottoNumber, int bonusNumber){
        if(lottoNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(InputValidMessage.REDUPLICATION.get());
        }

    }

    /**
     * 로또 번호 검사
     * @param numbers
     */
    public static void validLottoNumberSize(List<Integer> numbers) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException(InputValidMessage.REDUPLICATION.get());
        }
    }

    public static void validDuplicate(List<Integer> number){
        Set<Integer> lottoNo = new HashSet<>(number);

        if(lottoNo.size() != number.size()){
            throw new IllegalArgumentException(InputValidMessage.REDUPLICATION.get());
        }
    }


    /**
     * 입력받은 금액 유효성 검사
     * @param inputMoney
     * @return
     */

    public static boolean isValidMoney(String inputMoney){
        try {
            isCheckNumber(inputMoney);
            int money = Integer.parseInt(inputMoney);
            amoutRange(money);
            return true;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
