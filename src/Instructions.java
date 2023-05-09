import javax.swing.*;
import java.awt.*;

public class Instructions extends JPanel {

    private JLabel[] instructions;
    private JButton returnButton;

    public Instructions(int x, int y, int width, int height)
    {
        this.setBounds(x,y,width,height);
        this.setLayout(null);

        this.returnButton = Utils.newButton("BACK",
                this.getX()+this.getWidth() - Constants.BUTTON_WIDTH - Constants.MARGIN_FROM_LEFT,
                this.getY() +Constants.MARGIN_FROM_TOP );
        this.returnButton.addActionListener((e) ->{
            this.add(new MenuGame(Constants.X_WINDOW, Constants.Y_WINDOW, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
            removeObjects();
            repaint();
        });

        createInstructions();
        addObjects();
        this.setVisible(true);
    }

    private void createInstructions()
    {
        this.instructions = new JLabel[Constants.INSTRUCTIONS.length];
        JLabel welcome = Utils.newLabel(Constants.INSTRUCTIONS[0],
                this.getX()+this.getWidth()/2 - Constants.LABEL_WIDTH/2,
                this.getY()+Constants.MARGIN_FROM_TOP );
        this.instructions[0] = welcome;
        for (int i = 1;i<this.instructions.length ; i++)
        {
            JLabel label = Utils.newLabel(Constants.INSTRUCTIONS[i],
                    this.getX() +Constants.MARGIN_FROM_LEFT,
                    this.instructions[i-1].getY()+Constants.MARGIN_FROM_TOP );
            this.instructions[i] = label;
        }
    }

    private void addObjects()
    {
        for (int i = 0;i<this.instructions.length ; i++)
        {
            this.add(this.instructions[i]);
        }

        this.add(this.returnButton);
    }

    private void removeObjects()
    {
        for (int i = 0;i<this.instructions.length ; i++)
        {
            this.instructions[i].setVisible(false);
        }

        this.returnButton.setVisible(false);
    }


}
