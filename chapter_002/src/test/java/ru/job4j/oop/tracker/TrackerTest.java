package ru.job4j.oop.tracker;
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
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        //next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item[] result = tracker.findByName(item.getName());
        assertThat(result, is(new Item[]{item}));
    }
    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Item aaa = tracker.add(new Item("aaa"));
        Item bbb = tracker.add(new Item("bbb"));
        Item ccc = tracker.add(new Item("ccc"));
        assertThat(tracker.findAll(), is(new Item[]{aaa, bbb, ccc}));
    }
    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item aaa = tracker.add(new Item("aaa"));
        Item bbb = tracker.add(new Item("bbb"));
        Item ccc = tracker.add(new Item("ccc"));
        tracker.delete(bbb.getId());
        assertThat(tracker.findAll(), is(new Item[]{aaa, ccc}));
    }

}
