import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Brick extends Rectangle {
    private boolean destroyed;

    public Brick(int x, int y){
        this.x = x;
        this.y = y;
        this.width=40;
        this.height=10;
        destroyed=false;
    }

    public void paint(Graphics g){
        g.setColor(Color.orange);
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
        g.setColor(new Color(238,238,238));
        g.drawRoundRect(x, y, width, height,8,8);
        g.setColor(new Color(238,238,238));
        g.drawRect(x, y, width, height);

    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
