import javax.swing.*;

public class FlappyBird extends JFrame {

    public static void main(String[] args)
    {
        new FlappyBird();
    }

    public FlappyBird(){
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Flappy Bird by Shira & Hila & Sara");
        MenuGame menu = new MenuGame(Constants.X_WINDOW, Constants.Y_WINDOW, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.add(menu);
        this.setVisible(true);
    }
}