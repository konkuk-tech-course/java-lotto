package lotto.view;// @ author ninaaano

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.constant.OutputMessage;

import java.util.List;

public class OutputView {
    public static void printLottoNumber(int count) {
        System.out.printf(OutputMessage.RESPONSE_LOTTO_TICKET.get(),count);
        System.out.println();
    }

    public static void printLottoTicket(LottoTicket lottoTicket){
        List<Lotto> lottoTickets = lottoTicket.getLottoTickets();
        for(Lotto lotto : lottoTickets){
            StringBuilder lottoNumbers = new StringBuilder("[");
            createTicketPrint(lottoNumbers, lotto);
            lottoNumbers.delete(lottoNumbers.length() - 2, lottoNumbers.length())
                    .append("]");
            System.out.println(lottoNumbers);
        }
    }

    private static void createTicketPrint(StringBuilder lottoNumbers, Lotto lotto) {
        for (Integer integer : lotto.getLottoNumber()) {
            lottoNumbers.append(integer).append(", ");
        }
    }
}
