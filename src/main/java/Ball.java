import java.awt.*;

public class Ball extends Rectangle{

    private int xdir;
    private int ydir;

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.width=5;
        this.height=5;
        xdir = 1;
        ydir = -1;

    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.drawOval(x, y, width, width);
        g.fillOval(x, y, width, width);
    }

    void move() {

        x += xdir;
        y += ydir;

        if (x == 0) {
            //System.out.println(0);
            setXDir(1);

        }

        if (x == Commons.WIDTH.getValue() - 5) {
            //System.out.println(1);
            setXDir(-1);
        }

        if (y == 0) {
            //System.out.println(2);
            setYDir(1);
        }
    }

    public void setYDir(int ydir) {
        this.ydir = ydir;
    }

    public void setXDir(int xdir) {
        this.xdir = xdir;
    }

    public int getYDir() {
        return ydir;
    }
}
