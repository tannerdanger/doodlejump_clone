import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View extends JPanel implements KeyListener {

    private Game myGame;

    public View(Game game){
        myGame = game;
        setBackground(Color.WHITE);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_A
                ||e.getKeyCode() == KeyEvent.VK_LEFT){
            myGame.playerLeft();
        }else if(e.getKeyCode() == KeyEvent.VK_D
                ||e.getKeyCode() == KeyEvent.VK_LEFT){
            myGame.playerRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A
                ||e.getKeyCode() == KeyEvent.VK_LEFT){
            myGame.playerCenter();
        }else if(e.getKeyCode() == KeyEvent.VK_D
                ||e.getKeyCode() == KeyEvent.VK_LEFT){
            myGame.playerCenter();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        // clears old draw
        super.paintComponent(g);
        myGame.myPlayer.draw(g);
        for(Platform p : myGame.platforms){
            p.draw(g);
        }
    }
}
