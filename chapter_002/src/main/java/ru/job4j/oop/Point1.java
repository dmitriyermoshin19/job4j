package ru.job4j.oop;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point1 {
    private int x;
    private int y;
    private int z;

    public Point1(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public Point1(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }
    public double distance(Point1 that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
    public double distance3d(Point1 that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }
    public static void main(String[] args) {
        Point1 a = new Point1(0, 0, 4);
        Point1 b = new Point1(0, 2, 1);
        double dist = a.distance3d(b);
        System.out.println(dist);

        Point1 a1 = new Point1(0, 0);
        Point1 b1 = new Point1(0, 2);
        double dist1 = a1.distance(b1);
        System.out.println(dist1);
    }
}
