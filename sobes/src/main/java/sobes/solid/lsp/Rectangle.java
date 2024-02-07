package sobes.solid.lsp;

public class Rectangle {
    protected int width, height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
class Square extends Rectangle {
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}

class ShapeCalculator {
    public int getAreaWithParams(Rectangle r) {//метод принимающий разные типы под одним интерыейсом
        r.setWidth(5);
        r.setHeight(10);
        return r.getArea();//если неправильно переопределить метод в наследнике, то будет нарушение принципа
    }
}


class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Square s = new Square();
        ShapeCalculator calculator = new ShapeCalculator();

        int area1 = calculator.getAreaWithParams(r); //один тип подставили Rectangle
        System.out.println("Area of Rectangle is " + area1);

        int area2 = calculator.getAreaWithParams(s);// другой тип - наследник подставили Square
        System.out.println("Area of Square is " + area2);
    }
}
