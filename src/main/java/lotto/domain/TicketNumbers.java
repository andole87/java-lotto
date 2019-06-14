package lotto.domain;

import java.util.List;

public interface TicketNumbers {

    boolean contains(TicketNumber number);

    List<TicketNumber> numbers();
}
