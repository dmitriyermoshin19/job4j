package ru.job4j.oo3.sqlite.util.createxml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * класс пердназначен для  передачи элементов из таблицы entry
 */
@XmlRootElement
public class Entry {
    private int field;

    public Entry() {
    }

    public Entry(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return field == entry.field;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}
