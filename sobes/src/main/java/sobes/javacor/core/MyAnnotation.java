package sobes.javacor.core;

public @interface MyAnnotation {
    String value(); // Пример элемента аннотации типа String
    int count() default 0; // Пример элемента аннотации типа int со значением по умолчанию
}
