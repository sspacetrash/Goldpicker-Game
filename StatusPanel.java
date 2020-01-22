import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
/**
 * This class creates the status panel for main game, which displays the score of the game, and let the select the
 * mode.
 *
 * @HOI CHING NG
 * @version (a version number or a date)
 */
public class StatusPanel extends JPanel
implements ActionListener
{
    public  JLabel TimeLabel, EndlessModeLabel;
    public static JLabel ModeLabel, ScoreLabel, AttemptLabel, LivesLabel;
    private JButton ScoreMode, SurvivalMode, closeGameButton;
    public static String currentColorset = "Bright";
    
    public static boolean isScoreMode;
    

    private int score;

    /**
     * Constructer for the JPanel adding the buttons and labels.
     */
    public StatusPanel()
    {
        closeGameButton = new JButton("Close Game");
        closeGameButton.addActionListener(this);
        add(closeGameButton);
        closeGameButton.setVisible(true);

        ScoreMode = new JButton("Score Attack");
        ScoreMode.addActionListener(this);
        add(ScoreMode);

        SurvivalMode = new JButton ("Survival");
        SurvivalMode.addActionListener(this); 
        add(SurvivalMode);

        ScoreLabel = new JLabel("Current Score: " + GoldPicker.getScore());
        ScoreLabel.setFont(new Font("Monospaced", Font.ITALIC,15));
        ScoreLabel.setForeground(Color.WHITE);
        add(ScoreLabel);
        ScoreLabel.setVisible(false);

        AttemptLabel = new JLabel("Attempts:" + GoldPicker.getAttempts()); 
        ScoreLabel.setFont(new Font("Monospaced", Font.ITALIC,15));
        ScoreLabel.setForeground(Color.WHITE);
        add(AttemptLabel);
        AttemptLabel.setVisible(false);

        LivesLabel = new JLabel("Lives left:" + GoldPicker.getlives());
        LivesLabel.setFont(new Font("Monospaced", Font.ITALIC,15));
        LivesLabel.setForeground(Color.WHITE);
        add(LivesLabel);
        LivesLabel.setVisible(false);
        
    }

    public void actionPerformed(ActionEvent c) 
    {
        Object source = c.getSource();
        //Select score mode, showing the score only
        if (source == ScoreMode){
            isScoreMode = true;
            ScoreMode.setVisible(false);
            SurvivalMode.setVisible(false);
            ScoreLabel.setVisible(true);
        }
        //Select Survival mode, showing the lives counter
        if (source == SurvivalMode){
            isScoreMode = false;
            LivesLabel.setVisible(true);
            ScoreMode.setVisible(false);
            SurvivalMode.setVisible(false);
            ScoreLabel.setVisible(true);
        } 

        if (source == closeGameButton){
            CloseFrame close = new CloseFrame();
        } 
    }

    /**
     *Accessor method returning boolean isScoreMode which needs to be passed to EndLevel class. 
     */
    public static boolean getisScoreMode(){
        return StatusPanel.isScoreMode;
    }
/**
 * Set the text again, is used when the panel is clicked in GoldPciker class.
 */
    public static void refreshLabels(){
        ScoreLabel.setText("Current Score: " + GoldPicker.getScore());
        LivesLabel.setText("Lives left:" + GoldPicker.getlives());
    }
    
    public static String getColorset(){
        return StatusPanel.currentColorset;
    }
}