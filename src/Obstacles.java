import java.awt.*;
import java.util.Random;

public class Obstacles extends Thread{

    private int xUp ;

    private int xDown ;

    private int yUp ;

    private int yDown ;
    private int width;
    private int heightUp;
    private int heightDown;

    private Color color;
    private GameScene frame;

    private boolean isActive;

    private static int START_X = Constants.WINDOW_WIDTH/5;

    public Obstacles(GameScene scene){
        Random random = new Random();
        this.xUp = START_X;
        this.heightUp = random.nextInt(Constants.MIN_OBSTACLE_HEIGHT,scene.getHeight() - Constants.MIN_OBSTACLE_HEIGHT
                -Constants.BIRD_HEIGHT - Constants.BETWEEN_DISTANCE_OBSTACLE);
        this.yUp = Constants.Y_UP_OBSTACLE;

        this.xDown = START_X;
        this.heightDown = scene.getHeight()- this.heightUp -Constants.BIRD_HEIGHT - Constants.BETWEEN_DISTANCE_OBSTACLE;
        this.yDown = scene.getHeight() - this.heightDown;

        this.width = Constants.OBSTACLE_WIDTH;

        this.frame = scene;
        this.color = Color.cyan;
        this.isActive = true;

        START_X+= Constants.OBSTACLE_WIDTH +Constants.WIDTH_DISTANCE_OBSTACLE;
    }


    public void run() {
        while (this.isActive ){
            this.xUp--;
            this.xDown--;
            Utils.sleep(Constants.NECESSARY_STOP_TIME);
        }
    }

    public void setToNotActive(){
        this.isActive = false;
    }

    public Rectangle swapUpObstacleToRect()
    {
        return new Rectangle(this.xUp,this.yUp,this.width, this.heightUp - Constants.DISTANCE_TO_ACCURACY);
    }

    public Rectangle swapLowerObstacleToRect()
    {
        return new Rectangle(this.xDown,this.yDown,this.width,this.heightDown - Constants.DISTANCE_TO_ACCURACY);
    }

    public int getX(){
        return this.xUp;
    }

    public void paint(Graphics graphics){
        graphics.fillRect(this.xUp,this.yUp,this.width,this.heightUp);
        graphics.fillRect(this.xDown,this.yDown,this.width,this.heightDown);
        graphics.setColor(this.color);
    }

}
