package ru.job4j.oo3hibernate.integration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrdersStoreTest {
    private final BasicDataSource pool = new BasicDataSource();
    private OrdersStore store;

    @Before
    public void setUp() throws SQLException {
        pool.setDriverClassName("org.hsqldb.jdbcDriver");
        pool.setUrl("jdbc:hsqldb:mem:tests;sql.syntax_pgs=true");
        pool.setUsername("sa");
        pool.setPassword("");
        pool.setMaxTotal(2);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("./src/db/update_001.sql")))
        ) {
            br.lines().forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool.getConnection().prepareStatement(builder.toString()).executeUpdate();
        store = new OrdersStore(pool);
    }

    @After
    public void removeTable() throws SQLException {
        pool.getConnection().prepareStatement("DROP TABLE orders").execute();
    }

    @Test
    public void whenSaveOrderAndFindAllOneRowWithDescription() {
        store.save(Order.of("name1", "description1"));
        List<Order> all = (List<Order>) store.findAll();
        assertThat(all.size(), is(1));
        assertThat(all.get(0).getDescription(), is("description1"));
        assertThat(all.get(0).getId(), is(1));
    }

    @Test
    public void whenFindById() {
        Order order1 = store.save(Order.of("name1", "description1"));
        Order order = store.findById(order1.getId());
        assertThat(order.getDescription(), is("description1"));
    }

    @Test
    public void whenFindByName() {
        store.save(Order.of("name1", "description1"));
        Order order = store.findByName("name1");
        assertThat(order.getDescription(), is("description1"));
    }

    @Test
    public void whenReplace() {
        Order order1 = store.save(Order.of("name1", "description1"));
        Order order2 = Order.of("name2", "description2");
        order2.setId(order1.getId());
        store.replace(order2);
        assertThat(store.findByName(order2.getName()).getDescription(), is("description2"));
    }
}