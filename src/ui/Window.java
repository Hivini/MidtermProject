package ui;

import figures.*;
import figures.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Window extends JFrame {

    private JLabel area = new JLabel();
    private JLabel perimeter = new JLabel();
    private static JLabel displayLabel = new JLabel("Select a figure", SwingConstants.CENTER);
    private static JTextField figureSize = new JTextField("50");
    private Color circleColor = Color.red;
    private Color rectangleColor = Color.blue;
    private Color triangleColor = Color.green;
    private ArrayList<GeometricFigure> figures = new ArrayList<>();

    public Window() {
        super("Paint without budget");
        setSize(1280, 720);
        setLayout(new BorderLayout());


        // TODO: Make the controls look better
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(4, 2, 15, 40));
        controls.add(displayLabel);
        JPanel sizeFlow = new JPanel();
        sizeFlow.setLayout(new GridLayout(2, 1));
        sizeFlow.add(new JLabel("Enter size:", SwingConstants.CENTER));
        figureSize.setHorizontalAlignment(SwingConstants.CENTER);
        sizeFlow.add(figureSize);
        controls.add(sizeFlow);

        JButton circleButton = new JButton("Circle");
        circleButton.setForeground(circleColor);
        circleButton.addActionListener(e -> {
            displayLabel.setText("Circle");
        });
        controls.add(circleButton);

        JButton rectButton = new JButton("Rectangle");
        rectButton.setForeground(rectangleColor);
        rectButton.addActionListener(e -> {
            displayLabel.setText("Rectangle");
        });
        controls.add(rectButton);

        JButton triangleButton = new JButton("Triangle");
        triangleButton.setForeground(triangleColor);
        triangleButton.addActionListener(e -> {
            displayLabel.setText("Triangle");
        });
        controls.add(triangleButton);

        JButton eraseButton = new JButton("Erase");
        controls.add(eraseButton);

        JButton drawAllButton = new JButton("Draw all");
        controls.add(drawAllButton);

        // TODO: Change the layout type
        JPanel data = new JPanel();
        data.setLayout(new FlowLayout(FlowLayout.CENTER, 22, 5));
        data.add(new JLabel("Area"));
        data.add(area);
        data.add(new JLabel("Perimeter"));
        data.add(perimeter);

        JPanel board = new JPanel();
        board.setBackground(Color.white);

        // TODO: Add button functionality
        // This is the JPanel where we draw the figures, it's like the canvas.
        board.addMouseListener(new MouseListener() {

            private boolean isOnBoard = true;
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isOnBoard) {
                    Point a = e.getPoint();
                    int x = (int) a.getX();
                    int y = (int) a.getY();
                    System.out.println("Y" + y);
                    System.out.println("X" + x);
                    if (displayLabel.getText().equals("Rectangle")) {

                        Rectangle rectangle = new Rectangle(x, y,
                                Integer.parseInt(figureSize.getText()), rectangleColor);
                        figures.add(rectangle);
                        rectangle.draw(board.getGraphics());
                        area.setText(String.valueOf(rectangle.getArea()));
                        perimeter.setText(String.valueOf(rectangle.getPerimeter()));
                    } else if (displayLabel.getText().equals("Circle")) {
                        Circle circle = new Circle(x, y, Integer.parseInt(figureSize.getText()), circleColor);
                        figures.add(circle);
                        circle.draw(board.getGraphics());
                        area.setText(String.valueOf(circle.getArea()));
                        perimeter.setText(String.valueOf(circle.getPerimeter()));
                    } else if (displayLabel.getText().equals("Triangle")) {
                        Triangle triangle = new Triangle(x, y, Integer.parseInt(figureSize.getText()), triangleColor);
                        figures.add(triangle);
                        triangle.draw(board.getGraphics());
                        area.setText(String.valueOf(triangle.getArea()));
                        perimeter.setText(String.valueOf(triangle.getPerimeter()));
                    }

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse Entered");
                isOnBoard = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse exited");
                isOnBoard = false;
            }
        });

        eraseButton.addActionListener(e -> {
            board.repaint();
        });

        drawAllButton.addActionListener(e -> {
            for (GeometricFigure figure:
                 figures) {
                figure.draw(board.getGraphics());
            }
        });

        add(controls, BorderLayout.WEST);
        add(data, BorderLayout.SOUTH);
        add(board, BorderLayout.CENTER);

    }
}