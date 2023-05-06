import javax.swing.*;

public class MenuGame extends JPanel {

    private JButton startGame;

    public MenuGame(int x, int y, int width, int height){

        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.startGame = Utils.newButton("Start Game",
                (Constants.WINDOW_WIDTH /4)*3 -(Constants.BUTTON_WIDTH/2),
                (Constants.WINDOW_HEIGHT /4)*3);
       // this.setDoubleBuffered(true); //לבדוק למה משמש?

        this.add(this.startGame);
        this.startGame.addActionListener((e) ->{
           GameScene gameScene = new GameScene(Constants.X_WINDOW, Constants.Y_WINDOW, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
           this.add(gameScene);
           this.startGame.setVisible(false);
        });


        this.setVisible(true);

    }

}
