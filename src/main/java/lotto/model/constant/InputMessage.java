package lotto.model.constant;// @ author ninaaano

public enum InputMessage {

    REQUEST_INPUT_MONEY("구입금액을 입력해 주세요."),
    REQUEST_INPUT_LOTTO_NUMBER("당첨 번호를 입력해주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    private InputMessage (String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
