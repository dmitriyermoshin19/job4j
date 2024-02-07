package ru.job4j.collection.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByNameAndPriorityTest {
    @Test
    public void comparatorUserIncByName() {
        List<SortUser> users = new ArrayList<>();
        SortUser user1 = new SortUser("User1", 1);
        SortUser user2 = new SortUser("User2", 2);
        SortUser user3 = new SortUser("User3", 3);
        SortUser user4 = new SortUser("User4", 4);
        users.add(user4);
        users.add(user3);
        users.add(user2);
        users.add(user1);
        Collections.sort(users, new UserIncByName());
        List<SortUser> expected = List.of(user1, user2, user3, user4);
        assertThat(expected, is(users));
    }

    @Test
    public void comparatorUserIncByPriority() {
        List<SortUser> users = new ArrayList<>();
        SortUser user1 = new SortUser("User1", 1);
        SortUser user2 = new SortUser("User2", 2);
        SortUser user3 = new SortUser("User3", 3);
        SortUser user4 = new SortUser("User4", 4);
        users.add(user4);
        users.add(user3);
        users.add(user2);
        users.add(user1);
        Collections.sort(users, new UserIncByName());
        List<SortUser> expected = List.of(user1, user2, user3, user4);
        assertThat(expected, is(users));
    }

    @Test
    public void comparatorUserDescByName() {
        List<SortUser> users = new ArrayList<>();
        SortUser user1 = new SortUser("User1", 1);
        SortUser user2 = new SortUser("User2", 2);
        SortUser user3 = new SortUser("User3", 3);
        SortUser user4 = new SortUser("User4", 4);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Collections.sort(users, new UserDescByName());
        List<SortUser> expected = List.of(user4, user3, user2, user1);
        assertThat(expected, is(users));
    }

    @Test
    public void comparatorUserDescByPriority() {
        List<SortUser> users = new ArrayList<>();
        SortUser user1 = new SortUser("User1", 1);
        SortUser user2 = new SortUser("User2", 2);
        SortUser user3 = new SortUser("User3", 3);
        SortUser user4 = new SortUser("User4", 4);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Collections.sort(users, new UserDescByPriority());
        List<SortUser> expected = List.of(user4, user3, user2, user1);
        assertThat(expected, is(users));
    }

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<SortUser> cmpNamePriority = new UserDescByName().thenComparing(new UserDescByPriority());
        int rsl = cmpNamePriority.compare(
                new SortUser("User1", 2),
                new SortUser("User1", 1)
        );
        assertThat(rsl, lessThan(0));
        System.out.println(rsl);
    }

    @Test
    public void whenComparatorIncByNameAndPriority() {
        Comparator<SortUser> cmpNamePriority = new UserIncByName().thenComparing(new UserIncByPriority());
        int rsl = cmpNamePriority.compare(
                new SortUser("User2", 1),
                new SortUser("User2", 2)
        );
        assertThat(rsl, lessThan(0));
        System.out.println(rsl);
    }
}
