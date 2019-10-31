package ru.job4j.oop.ballStory;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        ball.goTo(hare);
        hare.tryEat(ball);
        ball.goTo(wolf);
        wolf.tryEat(ball);
        ball.goTo(fox);
        fox.tryEat(ball);
    }
}
