import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird extends Thread {

    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    private boolean isFlying;
    private ImageIcon image;



     public Bird(int x, int y, int width, int height ){
         this.x =x;
         this.y = y;
         this.width = width;
         this.height = height;
         this.speed = Constants.START_SPEED;
         this.isFlying = true;
         this.image = new ImageIcon("player.png");
     }

    public void run() {
        while (true){
            if (this.isFlying) {
                this.x += this.speed;
                this.speed+=Constants.INCREAS_ֹSPEED;
            }
        }
    }


    public void paint(Graphics graphics)
    {
        graphics.drawImage(this.image.getImage(),this.x,this.y,this.width, this.height,null );
    }

    public void setFlying(boolean status)
    {
        this.isFlying =status;
    }

    public void setSpeed(int speed)
    {
        this.speed =speed;
    }

}
