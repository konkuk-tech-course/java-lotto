package lotto.domain;

import lotto.constant.LotteryProperties;
import lotto.constant.Status;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private Money money;
    private List<Lotto> tickets;

    public User(String id, Money money) {
        this.id = id;
        this.money = money;
        tickets = new ArrayList<>();
    }

    public void buyTicket(Lotto ticket) {
        money.decreaseMoneyByUnit(LotteryProperties.PRICE.get());
        tickets.add(ticket);
    }

    public boolean hasMoney() {
        return money.getMoney() > Status.EMPTY.get();
    }

    public List<List<Integer>> createTicketsInfo() {
        List<List<Integer>> info = new ArrayList<>();
        tickets.forEach(ticket -> info.add(ticket.getNumbers()));
        return info;
    }

    public int getNumberOfTickets() {
        return tickets.size();
    }

    public String getId() {
        return id;
    }

    public int getMoney() {
        return money.getMoney();
    }
}
