import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Paddle paddle;
    private Timer timer;
    private Brick[] bricks;
    private Ball ball;

    public GamePanel() {
        setFocusable(true);
        setPreferredSize(new Dimension(Commons.WIDTH.getValue(), Commons.HEIGHT.getValue()));
        paddle = new Paddle(Commons.INIT_PADDLE_X.getValue(), Commons.INIT_PADDLE_Y.getValue());
        addKeyListener(this);
        bricks = new Brick[Commons.N_OF_BRICKS.getValue()];
        int k = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks[k] = new Brick(j * 40 + 30, i * 10 + 50);
                k++;
            }
        }
        timer = new Timer(10, this);
        timer.start();

    }

    private void stopGame() {

        timer.stop();
    }

    public void paint(Graphics g) {
        paddle.paint(g);
        for (int i = 0; i < Commons.N_OF_BRICKS.getValue(); i++) {
            if (!bricks[i].isDestroyed()) {
                bricks[i].paint(g);
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        paddle.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        paddle.keyReleased(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paddle.move();
        this.repaint();
    }
}
