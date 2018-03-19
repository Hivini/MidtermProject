package figures;

import java.awt.*;

public class Rectangle extends GeometricFigure {

    public Rectangle(int x, int y) {
        super(x, y);
    }

    @Override
    public float getPerimeter() {
        return 0;
    }

    @Override
    public float getArea() {
        return 0;
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(getX(), getY(), 200, 200);
        System.out.println("Rectangle draw");
    }


}
