import javax.swing.*;
import java.awt.*;

public class MenuGame extends JPanel {

    private JButton startGame;

    private JButton instructionsButton;
    private ImageIcon image;

    private int type;

    public MenuGame(int x, int y, int width, int height){

        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.type = 1;
        this.image = new ImageIcon("menuBackground.png");
        this.startGame = Utils.newButton("Start Game",
                (Constants.WINDOW_WIDTH /4)*3 -(Constants.BUTTON_WIDTH/2),
                (Constants.WINDOW_HEIGHT /4)*3);

        this.instructionsButton = Utils.newButton("Instructions" ,
                (Constants.WINDOW_WIDTH /4) -(Constants.BUTTON_WIDTH/2),
                (Constants.WINDOW_HEIGHT /4)*3);

       // this.setDoubleBuffered(true); //לבדוק למה משמש?

        this.add(this.startGame);
        this.add(this.instructionsButton);

        this.startGame.addActionListener((e) ->{
           GameScene gameScene = new GameScene(Constants.X_WINDOW, Constants.Y_WINDOW, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
           this.add(gameScene);
           this.startGame.setVisible(false);
           gameScene.requestFocus();
        });

        this.instructionsButton.addActionListener((e) ->{
            Instructions instructions = new Instructions(Constants.X_WINDOW, Constants.Y_WINDOW, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            this.add(instructions);
            this.startGame.setVisible(false);
            this.instructionsButton.setVisible(false);
            this.type =2;
            repaint();
        });


        this.setVisible(true);

    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
      if (this.type == 1){
          graphics.drawImage(this.image.getImage(),this.getX(),this.getY(),this.getWidth(), this.getHeight(),null );

      }
    }

}
