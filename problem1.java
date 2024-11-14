import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class problem1 implements ActionListener {
    private static JButton up, down, left, right;
    private static JLabel arrow, errorMessage;
    private static int x = 280, y = 280;
    private static final int ARROW_SIZE = 50;
    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 450; // Adjusted for the arrowArea height

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton temp = (JButton) e.getSource();
        switch (temp.getName()) {
            case "up" -> {
                if (y - 10 >= 10) {
                    y -= 10;
                    System.out.println("y: " + y);
                    arrow.setText("\u2191"); // Upwards arrow
                    errorMessage.setText(""); // Clear error message
                } else {
                    errorMessage.setText("Out of bounds!"); // Error message
                }
            }
            case "down" -> {
                if (y + 10 + ARROW_SIZE <= PANEL_HEIGHT) {
                    y += 10;
                    System.out.println("y: " + y);
                    arrow.setText("\u2193"); // Downwards arrow
                    errorMessage.setText(""); // Clear error message
                } else {
                    errorMessage.setText("Out of bounds!"); // Error message
                }
            }
            case "left" -> {
                if (x - 10 >= 10) {
                    x -= 10;
                    System.out.println("x: " + x);
                    arrow.setText("\u2190"); // Leftwards arrow
                    errorMessage.setText(""); // Clear error message
                } else {
                    errorMessage.setText("Out of bounds!"); // Error message
                }
            }
            case "right" -> {
                if (x + 10 + ARROW_SIZE <= PANEL_WIDTH) {
                    x += 10;
                    System.out.println("x: " + x);  
                    arrow.setText("\u2192"); // Rightwards arrow
                    errorMessage.setText(""); // Clear error message
                } else {
                    errorMessage.setText("Out of bounds!"); // Error message
                }
            }
        }
        arrow.setBounds(x, y, ARROW_SIZE, ARROW_SIZE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel arrowArea = new JPanel();
        JPanel panel = new JPanel();

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Set BorderLayout for the frame
        frame.add(arrowArea, BorderLayout.CENTER); // Add arrowArea to the center
        frame.add(panel, BorderLayout.SOUTH); // Add panel to the south

        arrowArea.setLayout(null);
        arrowArea.setBackground(Color.WHITE);
        arrowArea.setPreferredSize(new Dimension(600, 450)); // Set preferred size for the arrowArea
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(600, 125)); // Set preferred size for the panel

        int buttonWidth = 50;
        int buttonHeight = 25;
        int gap = 50;
        int totalWidth = 4 * buttonWidth + 3 * gap;
        int startX = (600 - totalWidth) / 2;
        System.out.println(startX);

        up = new JButton("\u2B06"); // Up arrow
        up.setBounds(startX, 50, buttonWidth, buttonHeight); // Adjust y coordinate
        up.setName("up");
        up.addActionListener(new problem1());
        panel.add(up);

        down = new JButton("\u2B07"); // Down arrow
        down.setBounds(startX + buttonWidth + gap, 50, buttonWidth, buttonHeight); // Adjust y coordinate
        down.setName("down");
        down.addActionListener(new problem1());
        panel.add(down);

        left = new JButton("\u2B05"); // Left arrow
        left.setBounds(startX + 2 * (buttonWidth + gap), 50, buttonWidth, buttonHeight); // Adjust y coordinate
        left.setName("left");
        left.addActionListener(new problem1());
        panel.add(left);

        right = new JButton("\u27A1"); // Right arrow
        right.setBounds(startX + 3 * (buttonWidth + gap), 50, buttonWidth, buttonHeight); // Adjust y coordinate
        right.setName("right");
        right.addActionListener(new problem1());
        panel.add(right);

        arrow = new JLabel("\u00B7"); // Middle dot
        arrow.setBounds(x, y, ARROW_SIZE, ARROW_SIZE);
        arrowArea.add(arrow);

        errorMessage = new JLabel("");
        errorMessage.setBounds(10, 10, 200, 25);
        panel.add(errorMessage);

        frame.setVisible(true);
    }
}