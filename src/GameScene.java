import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameScene extends JPanel {

    private Bird bird;
    private List<Obstacles> allObstacles;
    private ImageIcon image;


    public GameScene(int x, int y, int width, int height){
        this.setFocusable(true);
        this.requestFocus();
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.image = new ImageIcon("gameBackground.png");
        this.bird = new Bird(x,y + Constants.WINDOW_HEIGHT/2 - Constants.BIRD_HEIGHT/2);
        this.allObstacles = new ArrayList<>();
        this.addKeyListener(new Movement(this.bird));

        this.bird.start();
        createObstacles();
        mainGameScene();

        this.setVisible(true);
    }

    private void mainGameScene(){
        new Thread(() ->{
           while (true){

               if (this.bird.isCloseToObstacle(this.allObstacles.get(this.allObstacles.size()-1)))
               {
                   createObstacles();
               }

              if (!this.allObstacles.isEmpty()){
                 for (int i =0; i<this.allObstacles.size();i++){
                     Rectangle up = this.allObstacles.get(i).swapUpObstacleToRect();
                     Rectangle down = this.allObstacles.get(i).swapLowerObstacleToRect();
                     if (this.bird.isCollision(up,down))
                     {
                         this.bird.killBird();
                         stopObstacles();

                     }
                 }
              }

               this.repaint();
           }

        }).start();

    }


    private void stopObstacles(){
        if (!this.allObstacles.isEmpty()){
            for (int i=0; i< this.allObstacles.size();i++)
            {
                this.allObstacles.get(i).setToNotActive();
            }
        }
    }

    private void createObstacles()
    {
        for (int i =1;i<=Constants.CREATE_OBSTACLE;i++)
        {
            Obstacles obstacles = new Obstacles(this);
            obstacles.start();
            this.allObstacles.add(obstacles);
        }
    }


    private void paintAllObstacles(Graphics graphics)
    {
        if (!this.allObstacles.isEmpty() && this.allObstacles.size()>Constants.MIN_OBSTACLE_FOR_PAINT ){
            for (int i = 0; i<this.allObstacles.size(); i++)
            {
                this.allObstacles.get(i).paint(graphics);
            }
        }
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        graphics.drawImage(this.image.getImage(),this.getX(),this.getY(),this.getWidth(), this.getHeight(),null );
        this.bird.paint(graphics);
        paintAllObstacles(graphics);
    }
}
