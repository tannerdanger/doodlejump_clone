import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JFrame {

    private static final int D_WIDTH = 800;
    private static final int D_HEIGHT = 768;

    View myView;

    Player myPlayer;

    int width = 800;
    int height = 768;

 //   int unit = 10;
    int myBounceY = 0;
    int score = 0;

    private boolean playerLeft = false;
    private boolean playerRight = false;
    private boolean playerCenter = false;

    Timer myGameTimer;

    private int x = 100, y = 100, h = 100, myBounceHeight = 350;
    double dx = 0, dy = 1;

    List<Platform> platforms = new ArrayList<>();

    public Game() {

        setSize(D_WIDTH, D_HEIGHT);

        myView = new View(this);
        getContentPane().add(myView);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //pack();
        start();




    }

    public void start(){

        myPlayer = new Player(x,y);
        generatePlatforms();


        myGameTimer = new Timer(2, arg0 ->{
            update();
            draw();
        });

        myGameTimer.start();

    }

    public void update(){

        if(playerLeft){
            myPlayer.myX--;
        }else if(playerRight){
            myPlayer.myX++;
        }

        if(myPlayer.getY() > height){
            //todo: player fell off bottom of screen
        }

        if(myPlayer.getY() < myBounceY - myBounceHeight ){
            dy = 1;
        }

        if( dy > 0){ //if player is moving down
            for(Platform p : platforms){
                if(p.checkCollision(myPlayer)){
                        bounce();
                }
            }
        }else{

        }

        myPlayer.myY += dy;

    }

    public void bounce(){
        myBounceY = myPlayer.getY();
        dy = -3;
        score++;
    }



    public void draw(){
        myView.repaint(myView.getBounds());
    }

    public void playerLeft(){
        playerLeft = true;
        playerRight = false;
    }

    public void playerRight(){
        playerLeft = false;
        playerRight = true;
    }

    public void playerCenter(){
        playerCenter = true;
        playerLeft = false;
        playerRight = false;
    }




    private void generatePlatforms() {


        Random r = new Random();


        for (int i = 0; i < 10; i++) {


            int x = r.nextInt(width);
            int y = r.nextInt(height) ;
            //int w = r.nextInt(60) + 120;

            Platform p = new Platform(x, y);

            platforms.add(p);


        }
    }

}
