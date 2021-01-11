import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        GamePanel gamePanel = new GamePanel();
        frame.setBounds(10, 10, 300, 400);
        frame.setTitle("Breakout Ball");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);



    }
}
