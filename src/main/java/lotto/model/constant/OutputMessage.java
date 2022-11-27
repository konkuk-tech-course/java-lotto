package lotto.model.constant;// @ author ninaaano

public enum OutputMessage {

    RESPONSE_LOTTO_TICKET("%d개를 구매했습니다.");

    private final String message;

    private OutputMessage (String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
