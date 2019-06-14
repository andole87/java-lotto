package lotto.domain;

import java.util.List;

public interface UserTickets {
    List<Ticket> tickets();

    LottoResult result(WinningTicket winningTicket);
}
