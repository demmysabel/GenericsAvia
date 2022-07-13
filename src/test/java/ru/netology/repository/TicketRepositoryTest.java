package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {


    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1010, 15_000, "SVO", "ATH", 200);
    Ticket ticket2 = new Ticket(2020, 30_000, "VKO", "IST", 180);
    Ticket ticket3 = new Ticket(3030, 3000, "DME", "LED", 60);
    Ticket ticket4 = new Ticket(4040, 50_000, "VKO", "AYT", 220);


    @Test
    public void shouldAddTicketsInRepository() {
        repo.save(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);

        Ticket expected = ticket2;
        Ticket actual = repo.findById(2020);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);


        Ticket actual = repo.findById(5555);
        assertEquals(null, actual);
    }


    @Test
    public void shouldRemoveById() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);

        repo.removeById(2020);

        Ticket[] expected = {ticket1, ticket3, ticket4};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

}