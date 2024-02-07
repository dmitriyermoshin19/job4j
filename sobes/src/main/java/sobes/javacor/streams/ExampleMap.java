package sobes.javacor.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * сделать список В на основе списка А
 * только с четными b.y
 * преобразование А в В: b.y = 3*a.x/2
 */
public class ExampleMap {
    static class A {
        public int x;
        A(int x) {this.x = x;}
    }
    static class B {
        public int y;
        public B(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<A> listA = List.of(new A(1), new A(2));
        List<B> listB = listA.stream().map(a -> new B(3*a.x/2))
                .filter(b -> b.y % 2 == 0).collect(Collectors.toList());
    }
}
