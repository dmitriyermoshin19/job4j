package sobes.javacor.streams;

import java.util.stream.Stream;

public class Phones {
    static class Phone {
        private int code;
        private String number;
        Phone(int code, String number) {
            this.code = code;
            this.number = number;
        }
        @Override
        public String toString() {
            return this.number;
        }
    }

    public static void main(String[] args) {
        Stream.of(new Phone(1, "1"), new Phone(2, "2"))
                .map(Object::toString)
                .peek(System.out::println)
                .peek(System.out::println)
                .filter(e -> e.startsWith("2"))
                .forEach(System.out::println);
    }
//            1 .peek(System.out::println)
//            1 .peek(System.out::println)
//            2 .peek(System.out::println)
//            2 .peek(System.out::println)
//            2 .forEach(System.out::println);
}
