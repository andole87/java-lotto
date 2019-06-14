package lotto.domain;

public interface Ticket {

    public TicketNumbers ticketNumbers();

    public boolean contains(TicketNumber number);
}
