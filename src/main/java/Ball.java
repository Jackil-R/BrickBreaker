import java.awt.*;

public class Ball extends Rectangle{

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.width=5;
        this.height=5;

    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, width);
        g.fillOval(x, y, width, width);
    }

}
