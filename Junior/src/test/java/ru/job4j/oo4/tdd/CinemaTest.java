package ru.job4j.oo4.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class CinemaTest {
    Ticket3D ticket3D;
    Session session3D;
    Cinema cinema = new Cinema3D();

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = this.cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(ticket3D));
    }

    @Test
    public void find() {
        cinema.add(new Session3D());
        List<Session> sessions = this.cinema.find(session -> true);
        assertThat(sessions, is(List.of(session3D)));
    }

    @Test
    public void add() {
        this.cinema.add(new Session3D());
        assertThat(1, is(cinema.sessionCount()));
    }

    private static class AccountCinema implements Account {

    }

    private static class Ticket3D implements Ticket {

    }

    private static class Session3D implements Session {

    }

    private  class Cinema3D implements Cinema {

        @Override
        public List<Session> find(Predicate<Session> filter) {
            session3D = new Session3D();
            return List.of(session3D);
        }

        @Override
        public Ticket buy(Account account, int row, int column, Calendar date) {
            ticket3D = new Ticket3D();
            return ticket3D;
        }

        @Override
        public void add(Session session) {

        }

        @Override
        public int sessionCount() {
            return 1;
        }
    }
}
