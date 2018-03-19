package ui;

import figures.*;
import figures.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame {

    private JLabel area = new JLabel();
    private JLabel perimeter = new JLabel();
    private static JLabel displayLabel = new JLabel("Select a figure");
    private static JTextField figureSize = new JTextField();

    public Window() {
        super("Paint without budget");
        setSize(1280, 720);
        setLayout(new BorderLayout());


        // TODO: Make the controls look better
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(4, 2, 15, 40));
        controls.add(displayLabel);
        controls.add(figureSize);

        JButton circleButton = new JButton("Circle");
        circleButton.addActionListener(e -> {
            displayLabel.setText("Circle");
        });
        controls.add(circleButton);

        JButton rectButton = new JButton("Rectangle");
        rectButton.addActionListener(e -> {
            displayLabel.setText("Rectangle");
        });
        controls.add(rectButton);

        JButton triangleButton = new JButton("Triangle");
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

        // TODO: Add functionality
        Board board = new Board();
        board.setBackground(Color.white);
        board.addMouseListener(board);

        add(controls, BorderLayout.WEST);
        add(data, BorderLayout.SOUTH);
        add(board, BorderLayout.CENTER);

    }
}

class Board extends JPanel implements MouseListener {


    private boolean isOnBoard = false;
    @Override
    public void mouseClicked(MouseEvent e) {
        if (isOnBoard) {
            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
            int x = (int) b.getX();
            int y = (int) b.getY();
            System.out.println("Y" + y);
            System.out.println("X" + x);

            // TODO: Draw a fucking rectangle
            Rectangle rectangle = new Rectangle(x, y);
            System.out.println(rectangle.getArea());
            this.add(rectangle);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}