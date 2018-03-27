package figures;

import java.awt.*;

public class Circle extends GeometricFigure {
    private int size;
    private Color color;

    public Circle(int x, int y, int size, Color color) {
        super(x-(size), y-(size));
        this.size = size;
        this.color = color;
    }

    @Override
    public double getPerimeter() {
        return Math.round(2*Math.PI*size);
    }


    @Override
    public double getArea() {
        return Math.round(Math.PI *size*size);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(getX(), getY(), size*2, size*2);
        System.out.println("Circle drawn");
    }
}
