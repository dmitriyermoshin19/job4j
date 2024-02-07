package ru.job4j.sobes.javacor.collections;

import java.util.*;
import java.util.stream.Stream;

public class MyCollection {
    //1 пример типизированного метода
    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
    }
    //1 пример типизированного класса
    public static class Box<T> {

        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }

/*        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Box<?> box = (Box<?>) o;
            return Objects.equals(t, box.t);
        }

        @Override
        public int hashCode() {
            return Objects.hash(t);
        }*/
    }
    //2 пример типизированного метода
    public static class Util {
              //если мы поставили обобщенный тип <T> T, то надо его где то инициализировать!
        public static <T> T getValue(Object obj) {//все типы можно принимать как Object, потому что все типы наслудуют Object
            return (T) obj; //но возвращаем какой то один из них
        }
        public static <T> T getValue(Object obj, Class<T> tClass) {//инициализация типа
            return (T) obj;
        }
    }
    //2 пример типизированного класса
    public static class SomeType<T> {
        public <E> void test(Collection<E> collection) {//даже здесь стоит <E> void
            for (E element : collection) {
                System.out.println(element);
            }
        }
        public void test(List<Integer> collection) {
            for (Integer element : collection) {
                System.out.println(element);
            }
        }
    }
    //пример ограничения типа
                                    // <T extends Number & Comparable> - два интерфейса
    public static class NumberContainer<T extends Number> { //только для Number
        private T number;

        public NumberContainer(T number)  { this.number = number; }

        public void print() {
            System.out.println(number);
        }                        //  <? super T> - все типы-родители инициализируемого типа
                                  // <? extends T> - вее типы наследующие инициализируемый тип
        public static void print(List<? super String> list) {
            list.add("Hello World!");
            System.out.println(list.get(0));
        }
    }
    //пример с wildcard
    public static class Animal { //без статик ошибка: No enclosing instance of type 'ru.job4j.sobes.javacor.collections.MyCollection' is in scope

        public void feed() {

            System.out.println("Animal.feed()");
        }
    }

    interface Interface {
        int get(int sum);
    }
    abstract static class Abstract {
        abstract int set(int sum);
    }
    public static class Pet extends Abstract implements Interface {

        public void call() {//без абстр класса и интерфейса - без @Override

            System.out.println("Pet.call()");
        }

        @Override  // первый раз переопределили в родителе
        int set(int sum) {
            return 10;
        }
        @Override  // первый раз переопределили в родителе
        public int get(int sum) {
            return 0;
        }
    }

    public static class Cat extends Pet {
        public Cat() { //обход стирания типов
            System.out.println("Объект секретного класса успешно создан!");
        }

        public boolean meow() {
            set(2);
            get(1);
            call();
            System.out.println("Cat.meow()");
            return true;
        }

        @Override
        int set(int sum) {//второй раз переопределенный в наследнике
            return 20;
        }
        @Override
        public void call() { //переопределенный у родителя
//            super.call();
        }
        @Override //второй раз переопределили в наследнике -сигнатура не изменна
        public int get(int s) {
//            super.get()
            return 10;
        }
    }
    public static class Dog extends Pet implements Comparable<Dog> {
        String name;
        int name1;

        public Dog() {};
        public Dog(String name) {
            this.name = name;
        }

        public void bark() {

            System.out.println("Dog.bark()");
        }

        @Override
        public int compareTo(Dog o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dog dog = (Dog) o;
            return Objects.equals(name, dog.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name,name1);
        }
    }
    // List<Cat>, List<Dog> или List<Pet> не являются наследниками List<Animal>!
//    public static void iterateAnimals(Collection<Animal> animals) {
    public static void iterateAnimals(Collection<? extends Animal> animals) {

        for(Animal animal: animals) {

            System.out.println("Еще один шаг в цикле пройден!");
        }
    }                                            //мы исключили Dog
    public static void iterateAnimalsCat(Collection<? super Cat> animals) {

        for(int i = 0; i < animals.size(); i++) {//только с таким циклом работает - без обозначений типа объекта в коллекции как в форич

            System.out.println("Еще один шаг в цикле пройден!");
        }
    }
    //обход стирания типов
    public static class TestClass<T> {

        Class<T> typeParameterClass;

        public TestClass(Class<T> typeParameterClass) {
            this.typeParameterClass = typeParameterClass;
        }

        public T createNewT() throws IllegalAccessException, InstantiationException {
            System.out.println("---метод создающий экземпляр класса newInstance:---");
            T t = typeParameterClass.newInstance();
            return t;
        }
    }
    public static void main(String... args) throws InstantiationException, IllegalAccessException { // varargs
/*        String str1 = "I love Java";
//        str1 = "I love Python";
        String str2 = str1;//обе переменные-ссылки указывают на одну строку.
        System.out.println(str2);

        str1 = "I love Python";//но поведение str1 никак не влияет на str2
        System.out.println(str2);//str2 продолжает указывать на строку "I love Java", хотя str1 уже указывает на другой объект

        String str1AfterReplacement =  str1.replace("Java", "Python");
        System.out.println(str1AfterReplacement);*/

        //1 пример типизированного метода
/*        List<String> strings = new ArrayList<>();
        strings.add("Старая строка 1");
        strings.add("Старая строка 2");
        strings.add("Старая строка 3");

        fill(strings, "Новая строка");//первый тип

        System.out.println(strings);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        fill(numbers, 888);// другой тип
        System.out.println(numbers);*/

/*        //1 пример типизированного класса
        Box<String> stringBox = new Box<>();

        stringBox.set("Старая строка");
        System.out.println(stringBox.get());
        stringBox.set("Новая строка");

        System.out.println(stringBox.get());

//        stringBox.set(12345);//ошибка компиляции!*/

/*        //обход стирания типов
        Class<Integer> classInt = Integer.class;//Class инициализируется только так - создание объекта как в байт-коде
        Class<Cat> classCat = Cat.class;
        Cat cat = classCat.newInstance();//возвращает свой джинерик

        System.out.println(classInt);
        System.out.println(classCat);
        System.out.println(cat);

        TestClass<Cat> testCat = new TestClass<>(Cat.class);
        Cat secret = testCat.createNewT();
        Cat secret1 = testCat.createNewT();
        System.out.println(secret.meow());
        System.out.println(secret);
        System.out.println(secret1);*/

/*        //2 пример типизированного метода
        List list = Arrays.asList(2, 3);
        for (Object element : list) {
            System.out.println(Util.<Integer>getValue(element) + 1); //инициализация типа
            System.out.println(Util.getValue(element, Integer.class) + 1);
        }*/
        //2 пример типизированного класса
/*        SomeType<String> st = new SomeType<>();//всегда инициализировать дженерик SomeType<String>
        List<String> list = Arrays.asList("test");
        st.test(list);*/
/*        NumberContainer<Number> number1 = new NumberContainer<>(2L);
        NumberContainer number2 = new NumberContainer(1);
     //   NumberContainer number3 = new NumberContainer("f");//не компилируется - стринг*/
        //пример с wildcard
/*        List<Cat> cats = new ArrayList<>();//дженерик защищает, чтобы в коллекции были разные объекты
        cats.add(new Cat());
        cats.add(new Cat());

        //ошибка компилятора! если метод принимает iterateAnimals(Collection<Animal> animals)
        iterateAnimals(cats);

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());

        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet());
        pets.add(new Pet());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        iterateAnimals(animals);//все отлично работает с wildcard - можно подставлять коллекции с разными наследниками
        iterateAnimals(pets); //все отлично работает с wildcard
        iterateAnimals(dogs); //все отлично работает с wildcard

        iterateAnimalsCat(animals);
        iterateAnimalsCat(pets);
        iterateAnimalsCat(cats);*/
//        iterateAnimalsCat(dogs);  //ошибка компилятора! -мы исключили Dog - <? super Cat>


        /*
        Map<String, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> map = Map.of(1,1, 2, 2, 3, 3);
        hashMap.put("1", 1);
        Stream.of(map).forEach(System.out::println);
        List<String> list2 = new ArrayList<>();
        Stream.of(hashMap).forEach(System.out::println);
        list2.add("1");
        list2.forEach(o -> System.out.println("list = " + o));

        List<Integer> list1 = Arrays.asList(1,1,2,2,6);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int index = new Random().nextInt(5);
            list.add(list1.get(index));
            System.out.println(list1.get(index));
        }
        System.out.println(list);
        List<Integer> l = list1.stream().filter(i -> i < 3).collect(Collectors.toList());*/

/*
        List<String> list3 = Arrays.asList("1a", "1b", "1c", "0");
        //Function<String, String> u = s -> s + "0";
        UnaryOperator<String> u = String::toUpperCase;
        //String u = "3";
        List<String> list4 = list3.stream().filter(s -> s.contains("1"))
                .map(u).peek(System.out::println).collect(Collectors.toList());//peek прим.функц. к кажд.элементу
        System.out.println(list4);
        list3.stream().filter(s -> s.contains("1"))
                .map(u).forEach(System.out::println);// c forEach - применяет функцию к каждому объекту
*/

         List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        System.out.println(list2);//список упрорядоченных объектов*/
        System.out.println(list2.get(1));
        list2.remove(1); //сдвигается индекс
        System.out.println(list2.get(1));

/*        Set<Integer> set = new HashSet<>();
        set.add(111);
        set.add(133);
        set.add(122);
        System.out.println(set);//список неупрорядоченных объектов*/

/*        Set<String> set = new LinkedHashSet<>();
        set.add("bbb122");
        set.add("bbb122");
        set.add("aaa111");
        set.add("ccc133");
        set.add("ddd111");
        System.out.println(set);//список упрорядоченных объектов*/

/*         Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("bbb1333",2);
        hashMap.put("bbb1333",null);
        hashMap.put("aaa1223",3);
        hashMap.put("ccc1113",3);
        System.out.println(hashMap);
        //список неупрорядоченных объектов, не содержит дублей только в ключах-перезаписывает*/

        //пример с мутебл ключом
/*
        Map<Box<Integer>, Integer> map = new HashMap<>();
        Box<Integer> box = new Box<>();//чтобы вставить в мап надо переопр.хешкод и икволс!
        map.put(box, 1);
        map.put(new Box<>(), 2);//здесь перезапишет, если переопр.икволс
//        Stream.of(map).forEach(System.out::print);
        System.out.println("хешкод: " + box.hashCode());
        System.out.println(map.get(box));//здесь нашел значение по ключу - 1
        box.set(1);//без переопределения хешкода хешкод не меняется- если будет коллизия -перезапишет
        System.out.println("хешкод: " + box.hashCode());
        System.out.println(map.get(box));//здесь прошлое значение уже не найдет по этому же ключу
        map.put(new Box<>(), 2);
        for (Map.Entry<Box<Integer>, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Map<Integer, Box<Integer>> hashMap = new HashMap<>();
        hashMap.put(1, box);
//        box.set(2); //перезаписывает
        Box<Integer> box1 = new Box<>();
        box1.set(2);
        hashMap.put(2, box1);
        System.out.println(hashMap.containsValue(box1));//находит без хешкода в Box
        for (Map.Entry<Integer, Box<Integer>> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().get());
        }
*/

/*         Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("bbb1333",1);
        treeMap.put("bbb1333",2);
        treeMap.put("aaa1333",2);
        treeMap.put("ccc1113",2);
        System.out.println(treeMap);
        //список отсортированных по ключам объектов, не содержит дублей только в ключах-перезаписывает
//        Stream.of(treeMap).forEach(System.out::println);*/

/*        //пример без переопределения икволс и хешкод
        Dog dog = new Dog("Dog");
        Dog dog1 = new Dog("Dog");
        System.out.println(dog.equals(dog1));//без переопр. икволса будет фолс,
        // хотя объекты одинаковые
        Map<Dog, Integer> treeMap = new TreeMap<>();
        treeMap.put(dog, 1);
        treeMap.put(dog1, 2);//перезапишет потому что сначала ищет подобный ключ по объекту
        // даже если не ставить икволс и хешкод - из за компербл
//        dog1.name = ""; //если изменить объект мутебл - то не найдет
        System.out.println(treeMap.containsKey(dog1));//без икволса будет *тру все равно - из зи компербл
        // - значит переопределять икволс не обязательно!
        System.out.println(treeMap);

        Map<Integer, Dog> treeMap1 = new TreeMap<>();
        treeMap1.put(1, dog);
        System.out.println(treeMap1.containsValue(dog1));
        //без переопр.икволса в дог - фолс - с комперебл не подключен*/
    }
}
