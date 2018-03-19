package figures;

import javax.swing.*;
import java.awt.*;

abstract public class GeometricFigure extends JPanel{

    private int x, y;

    public abstract float getPerimeter();
    public abstract float getArea();
    public abstract void draw(Graphics g);

    GeometricFigure(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        System.out.println("FigureDraw");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
