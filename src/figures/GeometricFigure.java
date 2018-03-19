package figures;

import java.awt.*;

abstract public class GeometricFigure {

    private int x, y;

    public abstract float getPerimeter();
    public abstract float getArea();
    public abstract void draw(Graphics g);

    public GeometricFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
