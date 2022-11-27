package lotto.domain;

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

    public String getId() {
        return id;
    }

    public int getMoney() {
        return money.getMoney();
    }
}
