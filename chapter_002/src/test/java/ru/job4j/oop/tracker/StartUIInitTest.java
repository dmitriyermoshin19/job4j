package ru.job4j.oop.tracker;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUIInitTest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction("Stub action");
        new StartUI().init(input, new Tracker(), new UserAction[] {action });
        assertThat(action.isCall(), is(true));
    }
}
