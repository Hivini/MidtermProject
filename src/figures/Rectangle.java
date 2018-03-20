package figures;

import java.awt.*;

public class Rectangle extends GeometricFigure {

    private int size;
    private Color color;

    public Rectangle(int x, int y, int size, Color color) {
        super(x -size, y - size/2);
        this.size = size;
        this.color = color;
    }

    @Override
    public float getPerimeter() {
        return 6*size;
    }

    @Override
    public float getArea() {
        return (2 * size*size);
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(getX(), getY(), 2*size, size);
        g.setColor(color);
        System.out.println("Rectangle draw");
    }


}
