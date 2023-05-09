import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {

    private Bird bird;
    public Movement(Bird bird){
        this.bird = bird;

    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE ){
            this.bird.stopFlying();
            this.bird.setPlayerMovement(true);

        }
    }


    public void keyReleased(KeyEvent e) {
        this.bird.returnFlying();
        this.bird.setPlayerMovement(false);
    }
}
