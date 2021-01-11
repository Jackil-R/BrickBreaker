import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{
    private int dx;

    public Paddle(int x, int y){
        this.x = x;
        this.y = y;
        this.width=40;
        this.height=10;
    }

    public void paint(Graphics g){
        g.setColor(Color.black);
        g.drawRoundRect(x, y, width, height,5,5);
        g.fillRoundRect(x, y, width, height, 5,5);
    }

    void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
    }

    void move() {
        x += dx;
        if (x <= 0) {
            x = 0;
        }
        if (x >= Commons.WIDTH.getValue() - 40) {
            x = Commons.WIDTH.getValue() - 40;
        }
    }

    void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

}
