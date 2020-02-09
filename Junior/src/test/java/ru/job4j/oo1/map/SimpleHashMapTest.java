package ru.job4j.oo1.map;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleHashMapTest {
    private SimpleHashMap<String, String> simple = new SimpleHashMap<>();

    @Before
    public void setUp() {
        simple.insert("abc", "abc");
        simple.insert("cda", "cda");
        simple.insert("fga", "fga"); //колизия с сда не кладется
        simple.insert("ca", "ca"); //при ленч 4 - хешкод 3166 ячейка 2
        simple.insert("ac", "ac"); //колизия с са не кладется
    }

    @Test
    public void whenHashCodeAndGetIndex() {
        System.out.println("hashCode и индекс ячейки до увеличения длины массива");
        System.out.println("abc - " + "abc".hashCode() + "  индекс - " + simple.getIndex("abc"));
        System.out.println("cda - " + "cda".hashCode() + "  индекс - " + simple.getIndex("cda"));
        System.out.println("fga - " + "fga".hashCode() + "  индекс - "
                + simple.getIndex("fga") + " - коллизия с cda, не кладется в мар");
        System.out.println("ca - " + "ca".hashCode() + "  индекс - " + simple.getIndex("ca"));
    }

    @Test
    public void whenGetSizeKeysAndDeleteValueByKeyThenSizeUnchanged() {
        simple.delete("abc");
        assertThat(simple.getSizeKeys(), is(3));
    }

    @Test
    public void whenGetContainerChangeLengthThenGetByKeyValue() {
        simple.insert("abc", "abc");
        System.out.println("размвер массива - " + simple.getTable().length);
        System.out.println("до увеличения са здесь [2]- " + simple.getTable()[2]); //здесь са
        simple.insert("abb", "abb");
        System.out.println("увеличение размвера массива - " + simple.getTable().length);

        System.out.println("после увеличения са [2]- " + simple.getTable()[2] + ", теперь са здесь [6]- " + simple.getTable()[6]);
        simple.insert("ac", "ac"); //ячейка 2 как у са при ленч 4, здесь могла бы быть опять коллизия с са.
        simple.insert("fa", "fa"); //опять коллизия
        System.out.println();
        assertThat(simple.get("abc"), is("abc"));
        assertThat(simple.get("cda"), is("cda"));
        //assertThat(simple.get("fga"), is("fga"));
        assertThat(simple.get("ac"), is("ac"));
        assertThat(simple.get("ca"), is("ca"));
        //assertThat(simple.get("fa"), is("fa"));//

        System.out.println("hashCode и индекс ячейки после увеличения длины массива");
        System.out.println("abc - " + "abc".hashCode() + "  индекс - " + simple.getIndex("abc"));
        System.out.println("cda - " + "cda".hashCode() + "  индекс - " + simple.getIndex("cda"));
        System.out.println("fga - " + "fga".hashCode() + "  индекс - "
                + simple.getIndex("fga") + " - коллизия с cda, не кладется в мар");
        System.out.println("abb - " + "abb".hashCode() + "  индекс - " + simple.getIndex("abb"));
        System.out.println("ac - " + "ac".hashCode() + "  индекс - " + simple.getIndex("ac"));
        System.out.println("ca - " + "ca".hashCode() + "  индекс - " + simple.getIndex("ca"));
        System.out.println("fa - " + "fa".hashCode() + "  индекс - "
                + simple.getIndex("fa") + " - коллизия с abc, не кладется в мар");
    }

    @Test
    public void whenInsertTwoEqualsKeysThenKeyHaveSecondValue() {
        simple.insert("abc", "abc");
        simple.insert("abc", "cda");
        assertThat(simple.get("abc"), is("cda"));
    }

    @Test
    public void whenDeleteThenHasNextIsTrue() {
        Iterator<String> it = simple.iterator();
        simple.delete("cda");
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("ca"));
        assertThat(it.next(), is("abc"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNotHaveNextThenNSEE() {
        Iterator<String> it = simple.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        System.out.println(simple.getTable()[1]);
        assertThat(it.next(), is("cda"));
        assertThat(it.next(), is("ca"));
        assertThat(it.next(), is("abc"));
        assertThat(it.hasNext(), is(false));
        assertThat(it.next(), is("fga"));
        it.next();
    }
    /*
        @Test
    public void whenHashCodeAndGetIndex() {
        System.out.println("abc - " + "abc".hashCode() + "  индекс - " + simple.getIndex("abc"));
        System.out.println("cda - " + "cda".hashCode() + "  индекс - " + simple.getIndex("cda"));
        System.out.println("fga - " + "fga".hashCode() + "  индекс - "
                + simple.getIndex("fga") + " - коллизия с cda, не кладется в мар");
    }

    @Test
    public void whenGetSizeKeysAndDeleteValueByKeyThenSizeUnchanged() {
        simple.delete("abc");
        assertThat(simple.getSizeKeys(), is(2));
    }

    @Test
    public void whenGetContainerChangeLengthThenGetByKeyValue() {
        simple.insert("abc", "abc");
        System.out.println("размвер массива - " + simple.getTable().length);
        System.out.println("до увеличения са здесь [2]- " + simple.getTable()[2]); //здесь са
        simple.insert("abb", "abb");
        System.out.println("увеличение размвера массива - " + simple.getTable().length);

        System.out.println("после увеличения са [2]- " + simple.getTable()[2] + ", теперь са здесь [6]- " + simple.getTable()[6]);
        simple.insert("ac", "ac"); //ячейка 2 как у са при ленч 4, здесь могла бы быть опять коллизия с са.
        simple.insert("fa", "fa"); //опять коллизия
        System.out.println();
        assertThat(simple.get("abc"), is("abc"));
        assertThat(simple.get("cda"), is("cda"));
        //assertThat(simple.get("fga"), is("fga"));
        assertThat(simple.get("ac"), is("ac"));
        assertThat(simple.get("ca"), is("ca"));
        //assertThat(simple.get("fa"), is("fa"));//

        System.out.println("hashCode и индекс ячейки после увеличения длины массива");
        System.out.println("abc - " + "abc".hashCode() + "  индекс - " + simple.getIndex("abc"));
        System.out.println("cda - " + "cda".hashCode() + "  индекс - " + simple.getIndex("cda"));
        System.out.println("fga - " + "fga".hashCode() + "  индекс - "
                + simple.getIndex("fga") + " - коллизия с cda, не кладется в мар");
        System.out.println("abb - " + "abb".hashCode() + "  индекс - " + simple.getIndex("abb"));
        System.out.println("ac - " + "ac".hashCode() + "  индекс - " + simple.getIndex("ac"));
        System.out.println("ca - " + "ca".hashCode() + "  индекс - " + simple.getIndex("ca"));
        System.out.println("fa - " + "fa".hashCode() + "  индекс - "
                + simple.getIndex("fa") + " - коллизия с abc, не кладется в мар");
    }
    }

    @Test
    public void whenInsertTwoEqualsKeysThenKeyHaveSecondValue() {
        simple.insert("abc", "abc");
        simple.insert("abc", "cda");
        assertThat(simple.get("abc"), is("cda"));
    }

    @Test
    public void whenHashCodeAndGetIndex1() {

    }

    @Test
    public void whenDeleteThenHasNextIsTrue() {
        Iterator<String> it = simple.iterator();
        simple.insert("ac", "ac");
        simple.delete("cda");
        //assertThat(simple.get("cda"), is("cda")); //cda удалился
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        System.out.println("abc - " + "abc".hashCode() + "  индекс - " + simple.getIndex("abc"));
        System.out.println("ac - " + "ac".hashCode() + "  индекс - " + simple.getIndex("ac"));
        System.out.println("cda удалили - " + "cda".hashCode() + "  индекс - " + simple.getIndex("cda"));
        System.out.println("это cda удалили simple.getTable()[1]=" + simple.getTable()[1]);
        System.out.println("показывает из за переопр.toString в Ноде " + simple.getTable()[2]);
        System.out.println(simple.getTable()[3]);
        assertThat(it.next(), is("ac"));
        assertThat(it.next(), is("abc"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNotHaveNextThenNSEE() {
        Iterator<String> it = simple.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        System.out.println(simple.getTable()[1]);
        assertThat(it.next(), is("cda"));
        System.out.println(simple.getTable()[2]);
        System.out.println(simple.getTable()[3]);
        assertThat(it.next(), is("abc"));
        //assertThat(simple.get("fga"), is("fga"));//fga не вставился
        assertThat(it.hasNext(), is(false));
        assertThat(it.next(), is("fga"));
        it.next();
    }
     */
}
