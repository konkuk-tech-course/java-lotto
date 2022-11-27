package lotto.model.constant;// @ author ninaaano

public enum InputValidMessage {
    INPUT_MONEY_ERROR("[ERROR] 정확한 금액을 입력해주세요"),
    INPUT_NUMBER_ERROR("[ERROR] 숫자만 입력할 수 있습니다"),
    REDUPLICATION("[ERROR] 중복된 숫자는 입력할 수 없습니다")
    ;

    private final String message;

    private InputValidMessage (String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
