import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

     private Bird bird;

    public GameScene(int x, int y, int width, int height){
        this.setFocusable(true);
        this.requestFocus();
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.bird = new Bird(x,y + Constants.WINDOW_HEIGHT/2 - Constants.BIRD_HEIGHT/2
                ,Constants.BIRD_WIDTH,Constants.BIRD_HEIGHT);

        this.addKeyListener(new Movement(this.bird));

        repaintTread();
        this.bird.start();
        mainGameScene();

        this.setVisible(true);
    }

    private void mainGameScene(){
        new Thread(() ->{
           while (true){
               Utils.sleep(Constants.TIME_TO_SPEED);
               this.bird.increaseSpeed();
           }

        }).start();

    }

    private void repaintTread(){
        new Thread(() ->{
           while (true){
               this.repaint();
           }
       }).start();

    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        this.bird.paint(graphics);

    }
}
