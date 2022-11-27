package lotto.model;// @ author ninaaano

import lotto.model.constant.InputValidMessage;
import lotto.view.InputView;
import lotto.model.Lotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.model.constant.CommonCostants.IS_NUMBER;
import static lotto.model.constant.CommonCostants.MIN_LOTTO_PRICE;

public class InputValidator {

    public InputValidator() {
    }

    /**
     * 입력받은 로또 번호 유효성 검사
     */
    public static List<Integer> isValidNumber() {
        List<Integer> winningNumber = new ArrayList<>();
        try {
            //isCheckNumber(inputNumber);
            //int number = Integer.parseInt(inputNumber);
            //validateLottoNumber(number);
            String input = InputView.requestInputLottoNumber();
            winningNumber = Arrays.stream(input.split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            //System.out.println(InputValidMessage.INPUT_NUMBER_ERROR.get());
            throw new IllegalArgumentException(InputValidMessage.AMOUNT_RANGE.get());
        }
        return winningNumber;
    }

    public static void validateLottoNumber(int number) {
        if (!checkRange(number)) {
            System.out.println("로또 번호는 1 ~ 45 사이의 번호여야 합니다.");
            throw new IllegalArgumentException(InputValidMessage.AMOUNT_RANGE.get());
        }
    }

    public static boolean checkRange(int number) {
        return number >= 1 && number <= 45;
    }

    public static int isValidBonusNumber() {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(InputView.requestInputBonusNumber());
            // validateDuplicates(Lotto lotto,bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(InputValidMessage.REDUPLICATION.get());
        }
        return bonusNumber;
    }

    public static void validateDuplicates(Lotto lotteryNumbers, int bonusNumber) {
        if (lotteryNumbers.contains(bonusNumber)) {
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

    public static int isValidMoney(String inputMoney){
        int money = Integer.parseInt(inputMoney);
        try {
            isCheckNumber(inputMoney);
            amoutRange(money);
            return money;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(InputView.requestInputMoney());
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
