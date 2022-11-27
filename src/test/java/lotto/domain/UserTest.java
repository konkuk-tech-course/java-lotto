package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserTest {
    private static User user;
    private static Lotto ticket;

    @BeforeEach
    void beforeEach() {
        user = new User("id", new Money(2000));
        ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void When_buyTicket_Expect_MoneyDecreasedByUnit() {
        user.buyTicket(ticket);
        assertThat(user.getMoney()).isEqualTo(1000);
    }

    @Test
    void When_buyTicket_Expect_hasTicket() {
        user.buyTicket(ticket);
        assertThat(user.getNumberOfTickets()).isEqualTo(1);
    }

    @Test
    void createTicketsInfoTest() {
        Lotto secondTicket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        user.buyTicket(ticket);
        user.buyTicket(secondTicket);
        List<List<Integer>> info = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7)
        );
        assertThat(user.createTicketsInfo()).isEqualTo(info);
    }
}
