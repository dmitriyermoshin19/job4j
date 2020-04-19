package ru.job4j.oo3.sqlite;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class Entries {
    private List<Entry> entry;

    public Entries() {
    }

    public Entries(List<Entry> entry) {
        this.entry = entry;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entries entries = (Entries) o;
        return Objects.equals(entry, entries.entry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entry);
    }
}
