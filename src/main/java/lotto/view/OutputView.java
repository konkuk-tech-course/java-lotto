package lotto.view;

import lotto.view.constant.OutputPhrase;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String TICKET_PREFIX = "[";
    private static final String TICKET_SUFFIX = "]";

    private static OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printPurchasedTickets(List<List<Integer>> tickets) {
        System.out.printf(OutputPhrase.PURCHASE_COUNT.get(), tickets.size());
        insertLineBreak();
        tickets.stream()
                .map(this::styleTicket)
                .forEach(System.out::println);
    }

    private String styleTicket(List<Integer> ticket) {
        return ticket.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(
                DELIMITER,
                TICKET_PREFIX,
                TICKET_SUFFIX
        ));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void insertLineBreak() {
        System.out.println();
    }
}
