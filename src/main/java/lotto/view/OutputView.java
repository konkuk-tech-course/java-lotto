package lotto.view;

public class OutputView {
    private static OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
