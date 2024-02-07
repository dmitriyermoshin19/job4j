package ru.job4j.oo4.tdd;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {
    Generator simpleGenerator = new SimpleGenerator();
    String template = "I am a ${name}, Who are ${subject}? ";

    @Test
    public void whenTemplateComplete() {
        var args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );
        var result = simpleGenerator.produce(template, args);
        var expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(result, is(expected));

    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenNotEnough() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Ivan"
        );
        String out = simpleGenerator.produce(template, map);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenExtraArgs() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Ivan",
                "subject", "you",
                "something", "something"
        );
        String out = simpleGenerator.produce(template, map);
    }

    static class SimpleGenerator implements Generator {
        @Override
        public String produce(String template, Map<String, String> args) {
            return "I am a Petr Arsentev, Who are you? ";
        }
    }
}
