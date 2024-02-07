package ru.job4j.collection.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (var per : persons) {
            if (per.getName().contains(key) || per.getSurname().contains(key) || per.getPhone().contains(key) || per.getAddress().contains(key)) {
                result.add(per);
            }
        }
        return result;
    }
}
