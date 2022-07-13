package ru.netology.manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1010, 15_000, "SVO", "ATH", 200);
    Ticket ticket2 = new Ticket(2020, 30_000, "VKO", "IST", 180);
    Ticket ticket3 = new Ticket(3030, 3000, "DME", "LED", 60);
    Ticket ticket4 = new Ticket(4040, 50_000, "VKO", "AYT", 220);
    Ticket ticket5 = new Ticket(5050, 60_000, "VKO", "AYT", 200);

    @Test
    public void shouldFindMoreThanOneTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket4, ticket5};
        Ticket[] actual = manager.findAll("VKO", "AYT");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicket() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);


        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("VKO", "IST");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotSearchTicketInEmptyRepo() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVO", "ATH");
        assertArrayEquals(expected, actual);
    }
}