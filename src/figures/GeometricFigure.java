package figures;

import java.awt.*;

abstract public class GeometricFigure{

    private int x, y;

    public abstract float getPerimeter();
    public abstract float getArea();
    public abstract void draw(Graphics g);

    GeometricFigure(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
