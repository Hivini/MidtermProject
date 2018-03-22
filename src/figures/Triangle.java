package figures;

import java.awt.*;

public class Triangle extends GeometricFigure {

    private int size;
    private Color color;

    public Triangle(int x, int y, int size, Color color) {
        super(x - (size), y + (size) );
        this.size = size;
        this.color = color;
    }

    @Override
    public double getPerimeter() {
        return (getX()+(size*2) - getX()) * 3;
    }

    @Override
    public double getArea() {
        return ((getX()+(size*2) - getX()) * (getY()-(getY()-size*2))) / 2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[] pointsx = {getX(), getX() + size, getX()+(size*2)};
        int[] pointsy = {getY(), getY() - (size*2), getY()};
        g.fillPolygon(pointsx, pointsy, 3);
        System.out.println("Triangle drawn");
    }
}
