import java.awt.*;

public class Player extends Drawable {
    int myWidth, myHeight;
    Image leftFacing, rightFacing;

    public Player(int theX, int theY, View theView){
        myX = theX;
        myY = theY;
        rightFacing = Toolkit.getDefaultToolkit().getImage("img/doodleRight.png");
        leftFacing = Toolkit.getDefaultToolkit().getImage("img/doodleLeft.png");
        myImg = leftFacing;
//        myWidth= 24;
//        myHeight = 24;
        myWidth= 60;
        myHeight = 59;
    }

    public int getHeight(){
        return myHeight;
    }

    public int getWidth(){
        return myWidth;
    }

    public void draw(Graphics g, View v){
        g.setColor(Color.BLUE);
        //g.drawRect(myX, myY, myWidth, myHeight);
        g.drawImage(myImg, myX, myY, myImg.getHeight(v), myImg.getWidth(v), v);
    }
}
