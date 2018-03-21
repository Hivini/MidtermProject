package figures;

import java.awt.*;

public class Circle extends GeometricFigure {
    private int size;
    private Color color;

    public Circle(int x, int y, int size, Color color) {
        super(x-(size/2), y-(size/2));
        this.size = size;
        this.color = color;
    }

    @Override
    public double getPerimeter() {
        return 4*Math.PI*size;
    }

    @Override
    public double getArea() {
        return Math.PI*2*size*size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(getX(), getY(), size, size);
        System.out.println("Circle drawn");
    }
}
