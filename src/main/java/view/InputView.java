package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.WinningNumber;
import utils.Util;

import java.util.List;

public class InputView {
    public static final int UNIT = 1_000;
    public static final int LOTTO_SIZE = 6;

    private final WinningNumber winningNumber = new WinningNumber();

    public int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Util.convertStringToInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    private void validateMoney(int money) {
        checkUnit(money % UNIT);
    }

    private void checkUnit(int remainder) {
        if (remainder != 0 ) throw new IllegalArgumentException("[ERROR] 1,000 단위로 입력해야 합니다.");
    }

    public List<Integer> readWinningNumbers() {
        // 의문 1. 이렇게 Winningnumber에 저장해도되나? (이름에서 반환한다는 말이 없으니 그냥 숫자 리스트로 반환..)
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Util.convertStringToList(Console.readLine());
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }


    private void validateWinningNumbers(List<Integer> winningNumbers) {
        checkWinningNumberSize(winningNumbers);
        checkWinningNumberRange(winningNumbers);
        checkDuplicateNumber(winningNumbers);
    }

    private void checkDuplicateNumber(List<Integer> winningNumbers) {
        if (isDuplicateNumberExist(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 값을 입력하셨습니다.");
        }
    }

    private boolean isDuplicateNumberExist(List<Integer> winningNumbers) {
        return winningNumbers.size() != winningNumbers.stream().mapToInt(i -> i).distinct().count();
    }

    private void checkWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 값을 입력하셔야 합니다.");
        }
    }

    private void checkWinningNumberRange(List<Integer> winningNumbers) {
        winningNumbers.forEach(this::isWithinRange);
    }

    private void isWithinRange(Integer winningNumber) {
        if (winningNumber > 45 || winningNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 1~45까지의 숫자를 입력해야 합니다");
        }
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Util.convertStringToInt(Console.readLine());
        validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        isWithinRange(bonusNumber);
        // winning number를 가져와야 비교를함.. -> validate 하는 클래스 분리 필요.. 어떤 구조로 짜야하지..?
        // 근데 인스턴스변수로 winning number를 받으면 뭔가 좀 이상함. 왜냐면 inputView는 read하는 역할만 하는데.. 여러역할을 함..
        isDuplicateNumberWithWinningNumbers(bonusNumber);

    }

    //TODO
    private void isDuplicateNumberWithWinningNumbers(int bonusNumber) {
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수는 보너스 넘버가 될 수 없습니다");
        }
    }
/*
    public static void main(String[] args) {
        InputView inputView = new InputView(winningNumber);
        inputView.validateWinningNumbers(List.of(1, 2, 6, 4, 5,6));
    }*/
}
