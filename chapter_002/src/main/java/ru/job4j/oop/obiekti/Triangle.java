package ru.job4j.oop.obiekti;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a, double b, double c) {
        double per = (a + b + c) / 2;
        return per;
    }

    private boolean exist(double a, double c, double b) {
        boolean result = a + b > c && a + c > b && b + c > a;
        return result;
    }

    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 2);
        Triangle tri = new Triangle(a, b, c);
        double triArea = tri.area();
        System.out.println(triArea);
    }
}
