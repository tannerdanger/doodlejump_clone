import java.awt.*;

public class Player extends Drawable {
    int myWidth, myHeight;

    public Player(int theX, int theY){
        myX = theX;
        myY = theY;
        myWidth= 24;
        myHeight = 24;
      //  myImg = Toolkit.getDefaultToolkit().getImage("img/")
    }

    public int getHeight(){
        return myHeight;
    }

    public int getWidth(){
        return myWidth;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.drawRect(myX, myY, myWidth, myHeight);
    }
}
