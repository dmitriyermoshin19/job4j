package ru.job4j.oop;
import org.junit.Test;
import ru.job4j.oop.tracker.Item;
import ru.job4j.oop.tracker.Tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenAddNewItemThenTrackerHasSameItem1() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findByName(item.getName());
        assertThat(result.getId(), is(item.getId()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItemThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        System.out.println(item.getName());
        Item next = new Item("test2");
        tracker.add(next);
        System.out.println(next.getName());
        Item next1 = new Item("test3");
        tracker.add(next);
        System.out.println(next1.getName());
        Item result = tracker.delete(item.getId());
        assertThat(result.getName(), is(next.getName()));
    }
}
