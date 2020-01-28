package ru.job4j.oo1.generic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class UserStoreTest {
    User user1 = new User("1");
    User user2 = new User("2");
    User user3 = new User("3");
    UserStore userStore = new UserStore(4);

    @Before
    public void setUp() {
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
    }

    @Test
    public void whenGetPosition() {
        int result = userStore.getPosition("3");
        Assert.assertThat(result, is(2));
    }

    @Test
    public void whenReplace() {
        User userX = new User("X");
        boolean result = userStore.replace("2", userX);
        Assert.assertThat(result, is(true));
        Assert.assertThat(userStore.getPosition("X"), is(1));
    }

    @Test
    public void whenDelete() {
        boolean result = userStore.delete("1");
        Assert.assertThat(result, is(true));
        Assert.assertThat(userStore.getPosition("2"), is(0));
    }

    @Test
    public void whenFindById() {
        User result = userStore.findById("1");
        Assert.assertThat(result.getId(), is("1"));
    }
}
