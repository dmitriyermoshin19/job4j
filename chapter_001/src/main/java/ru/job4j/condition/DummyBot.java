package ru.job4j.condition;

public class DummyBot {

    public static String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        String question1 = "Привет, Бот.";
        String question2 = "Пока.";
        if (question1.equals(question)) {
            rsl = "Привет, умник.";
        } else if (question2.equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }

    public static void main(String[] args) {
        DummyBot bot = new DummyBot();
        String myquestion = "Привет, Бот.";
        String answer = bot.answer(myquestion);
        System.out.println(answer);
    }

}
