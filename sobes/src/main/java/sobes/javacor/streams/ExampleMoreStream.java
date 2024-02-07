package sobes.javacor.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleMoreStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(new Integer(1), new Integer(2));
        Stream<Integer> s = list.stream().map(integer -> integer + 1);
        List<Integer> list1 = s.collect(Collectors.toList());
       // Set<Integer> set = s.collect(Collectors.toSet());//здесь выкидывает ошибку: стрим был использован
        System.out.println("list1: " + list1);
       // System.out.println("set: " + set);
    }
}
