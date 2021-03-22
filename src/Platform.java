import java.awt.*;

public class Platform extends Drawable {
    int myWidth, myHeight;

    public Platform(int theX, int theY){
        myX = theX;
        myY = theY;
        myWidth= 58;
        myHeight = 15;
        myImg = Toolkit.getDefaultToolkit().getImage("img/platformGreen.png");

    }

    public boolean checkCollision(Player p){
        int bottom = (p.getY() + (p.getHeight()/2)); //players bottom

        if(bottom <= bottomOfPlatform() //bottom of player is less than the bottom of platform
                && bottom >= topOfPlatform()){ //bottom of player is below top of platform

            if(p.getX() + (p.getWidth()/2) >= platformLeft()
                    && p.getX() - (p.getWidth()/2) <= platformRight()){
                return true;
            }
        }
        return false;
    }

    private int platformLeft(){
        return myX - myWidth/2;
    }

    private int platformRight(){
        return myX + myWidth/2;
    }


    private int bottomOfPlatform(){
        int bot = myY + myHeight/2;
        return bot;
    }

    private int topOfPlatform(){
        int top = myY - myHeight/2;
        return top;
    }


    public void draw(Graphics g, View v){
        g.setColor(Color.RED);

        //g.fillRect(myX, myY, myWidth, myHeight);
        g.drawImage(myImg, myX, myY, myWidth, myHeight, v);
    }


}
