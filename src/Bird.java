import javax.swing.*;
import java.awt.*;

public class Bird extends Thread{

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isFlyingDown;

    private boolean isAlive;
    private boolean playerMovement;
    private ImageIcon image;

    private int speed;



     public Bird(int x, int y){
         this.x =x;
         this.y = y;
         this.width = Constants.BIRD_WIDTH;
         this.height = Constants.BIRD_HEIGHT;
         this.isFlyingDown = true;
         this.isAlive=true;
         this.image = new ImageIcon("player.png");
         this.playerMovement = false;
         this.speed=Constants.BIRD_SPEED;
     }

    public void run() {
        while (true){
            if (this.isFlyingDown && this.isAlive) {
                this.y+=this.speed;
            }else if (this.playerMovement && this.isAlive){
//                System.out.println("stop");
                this.y-=this.speed;
            }
            Utils.sleep(Constants.NECESSARY_STOP_TIME);
        }
    }


    public void killBird(){
         this.isAlive = false;
    }


    public void stopFlying()
    {
        this.isFlyingDown =false;
    }

    public void returnFlying(){
          this.isFlyingDown = true;
    }

    public void setPlayerMovement(boolean status)
    {
        this.playerMovement = status;
    }


    private Rectangle swapBirdToRect()
    {
    return new Rectangle(this.x,this.y,this.width -Constants.DISTANCE_TO_ACCURACY, this.height -Constants.DISTANCE_TO_ACCURACY);
    }

    public boolean isCollision(Rectangle up, Rectangle down){
         boolean result = false;
         Rectangle birdRect = swapBirdToRect();
         if (birdRect.intersects(up) ||
                 birdRect.intersects(down))
         {
             result = true;
         }
         return result;
    }

    public boolean isCloseToObstacle(Obstacles obstacle)
    {
        boolean result = false;
        if (this.x - obstacle.getX() < Constants.CLOSE_DISTANCE_OBSTACLE)
        {
            result = true;
        }
        return result;
    }

    public void paint(Graphics graphics)
    {
        graphics.drawImage(this.image.getImage(),this.x,this.y,this.width, this.height,null );

    }

}
