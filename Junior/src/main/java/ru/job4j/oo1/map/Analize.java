package ru.job4j.oo1.map;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> previousMap = new HashMap<>();
        int old = 0;

        for (User u : previous) {
            previousMap.put(u.id, u);
        }
        for (User u : current) {
            if (previousMap.containsKey(u.id)) {
                if (previousMap.get(u.id).name.equals(u.name)) {
                    old++;
                } else {
                    info.changed++;
                }
            }
        }
        int remained = old + info.changed;
        info.deleted = previous.size() - remained;
        info.added = current.size() - remained;
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    public static class Info {
        int added;
        int changed;
        int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
