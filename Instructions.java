import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * A class that displays the instructions in a seperate frame.
 *
 * @HOI CHING NG
 * @version (a version number or a date)
 */
public class Instructions extends JFrame
{
    private JLabel SurvivalTitle, ScoreTitle;
    private JLabel SurvivalContent, ScoreContent;

    /**
     * Constructor for objects of class Instructions
     */
    public Instructions()
    {
        super("Gold Picker Game"); 
        setSize(480,600); //horizontally, vertically
        this.setLayout(new FlowLayout(10,10,10));
        makeFrame();
        setVisible(true);
        
    }

    public void makeFrame()
    {
        Font TitleFont = new Font("Serif", Font.BOLD, 20);
        
        SurvivalTitle = new JLabel("Endless");
        SurvivalTitle.setFont(TitleFont);
        this.add(SurvivalTitle);
        
        SurvivalContent = new JLabel("<html>In Survival Mode, time is unlimited, but you only have three lives, <br>and you lose a life when you clicked the wrong rectangle</html>");
        this.add(SurvivalContent);
        
        ScoreTitle = new JLabel("Score Attack");
        ScoreTitle.setFont(TitleFont);
        this.add(ScoreTitle);
        
        ScoreContent = new JLabel("<html> In Score Mode,you just have to reach up to 10 points! Without time limit or limited lives, so treat it as a practice mode! <br> </html>");
        this.add(SurvivalContent);
    }
}
