package lotto.domain.ticket;

import java.util.List;

public interface TicketNumbers {

    boolean contains(TicketNumber number);

    List<TicketNumber> numbers();
}
