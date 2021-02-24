package ru.job4j.oo3hibernate.hql.ohql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int rate;

    public static Vacancy of(String name, int rate) {
        Vacancy vacancy = new Vacancy();
        vacancy.name = name;
        vacancy.rate = rate;
        return vacancy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id
                && rate == vacancy.rate
                && Objects.equals(name, vacancy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rate);
    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "Id=" + id
                + ", name='" + name + '\''
                + ", rate=" + rate
                + '}';
    }
}
