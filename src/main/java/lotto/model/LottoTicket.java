package lotto.model;// @ author ninaaano

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    public LottoTicket(int count) {
        createLottoTickets(count);
    }

    private void createLottoTickets(int ticketNumber) {
        for (int i = 0; i < ticketNumber; i++) {
            List<Integer> lottoNumber = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumber);
            Lotto lotto = new Lotto(lottoNumber);
            lottoTickets.add(lotto);
        }
    }

    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }


}
