import java.awt.*;

public class Platform extends Drawable {
    int myWidth, myHeight;

    public Platform(int theX, int theY){
        myX = theX;
        myY = theY;
        myWidth= 56;
        myHeight = 16;

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


    @Override
    public void draw(Graphics g){
        g.setColor(Color.RED);

        g.fillRect(myX, myY, myWidth, myHeight);
    }


}
