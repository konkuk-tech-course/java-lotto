package lotto.constant;

public enum GameException {

    ERROR_USER_MONEY("[ERROR] 사용자의 금액은 숫자로만 입력될 수 있습니다. "),
    ERROR_USER_MONEY_UNIT("[ERROR] 사용자의 금액은 1000원 단위로만 올 수 있습니다."),
    ERROR_LOTTO_NUMBER("[ERROR] 로또 번호에는 숫자 형태로만 올 수 있습니다."),
    ERROR_BONUS_NUMBER("[ERROR] 보너스 번호에서는 숫자가 와야합니다."),
    ERROR_BONUS_DUPLICATE("[ERROR] 보너스 번호에서는 중복된 숫자가 올 수 없습니다."),
    ERROR_BONUS_RANGE("[ERROR] 보너스 번호에서의 숫자 범위는 1-45사이입니다."),
    ERROR_LOTTO_SIZE("[ERROR] 로또 번호의 갯수는 6개여야 합니다."),
    ERROR_LOTTO_DUPLICATE("[ERROR] 로또 번호에서는 중복된 숫자가 올 수 없습니다."),
    ERROR_LOTTO_RANGE("[ERROR] 로또 번호에서의 숫자 범위는 1-45사이입니다.");



    private String message;

    GameException(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
