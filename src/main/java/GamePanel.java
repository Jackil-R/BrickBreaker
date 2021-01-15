import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Paddle paddle;
    private Timer timer;
    private List<Brick> bricks;
    private Ball ball;
    private String endGameMessage = "Game Over";
    private boolean inGame = true;


    public GamePanel() {
        setFocusable(true);
        setPreferredSize(new Dimension(Commons.WIDTH.getValue(), Commons.HEIGHT.getValue()));
        paddle = new Paddle(Commons.INIT_PADDLE_X.getValue(), Commons.INIT_PADDLE_Y.getValue());
        ball = new Ball(Commons.INIT_BALL_X.getValue(), Commons.INIT_BALL_Y.getValue());
        addKeyListener(this);
        bricks = new ArrayList<Brick>();

        int k = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks.add(k,new Brick(j * 40 + 30, i * 10 + 50));
                k++;
            }
        }
        timer = new Timer(Commons.PERIOD.getValue(), this);
        timer.start();

    }

    private void stopGame() {
        inGame = false;
        timer.stop();
    }

    public void paint(Graphics g) {
        ball.paint(g);
        paddle.paint(g);
        for (int i = 0; i < bricks.size(); i++) {
            bricks.get(i).paint(g);
        }

        if(!inGame){
           super.paint(g);
           gameFinished(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

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
        ball.move();
        paddle.move();
        checkCollision();
        this.repaint();
    }

    public void checkCollision(){

        if (ball.getMaxY() > Commons.BOTTOM_EDGE.getValue()) {
            endGame("Game Over");
        }

        if(ball.isEmpty()){
            endGame("Victory");
        }

        if (ball.intersects(paddle)) {

            int paddlePosition = (int) paddle.getMinX();
            int ballLPosition = (int) ball.getMinX();

            int firstSplit = paddlePosition + 8;
            int secondSplit = paddlePosition + 16;
            int thirdSplit = paddlePosition + 24;
            int fourthSplit = paddlePosition + 32;

            if (ballLPosition < firstSplit) {
                ball.setXDir(-1);
                ball.setYDir(-1);
            }
            if (ballLPosition >= firstSplit && ballLPosition < secondSplit) {
                ball.setXDir(-1);
                ball.setYDir(-1 * ball.getYDir());
            }
            if (ballLPosition >= secondSplit && ballLPosition < thirdSplit) {
                ball.setXDir(0);
                ball.setYDir(-1);
            }
            if (ballLPosition >= thirdSplit && ballLPosition < fourthSplit) {
                ball.setXDir(1);
                ball.setYDir(-1 * ball.getYDir());
            }
            if (ballLPosition > fourthSplit) {
                ball.setXDir(1);
                ball.setYDir(-1);
            }
        }

        for(int i=0; i<bricks.size(); i++){
            if(ball.intersects(bricks.get(i))){
                ball.setYDir(-1 * ball.getYDir());
                bricks.remove(i);
            }
        }


    }

    private void gameFinished(Graphics g) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(endGameMessage,
                (Commons.WIDTH.getValue() - fontMetrics.stringWidth(endGameMessage)) / 2, Commons.WIDTH.getValue() / 2);
    }

    private void endGame(String message) {
        stopGame();
        endGameMessage = message;
    }
}
