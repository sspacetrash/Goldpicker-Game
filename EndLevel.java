

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
/**
 * Write a description of class EndLevel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EndLevel extends JFrame
implements ActionListener
{
    private JLabel Status;
    private JButton restartButton, closeButton;
    
    public EndLevel(){
        super("End Level"); //Add title to window
        setSize(500,300); //set window size horizontally, vertically
        setLayout(new FlowLayout()); 
        makeFrame();
        setVisible(true);
    }

    public void makeFrame(){
       Status = new JLabel ("Game Ended! Would you like to restart or close the game?");
       add(Status);
       
       restartButton = new JButton("Restart");
       add(restartButton);
       closeButton = new JButton("Close");
       add(closeButton);
       restartButton.addActionListener(this);
       closeButton.addActionListener(this);
       
       
    }
    @Override
    public void actionPerformed(ActionEvent g) 
    {
        Object source = g.getSource(); 
        //reopen welcome page frame to simulate the start of game
        if (source == restartButton){
            WelcomePage restart = new WelcomePage();
        }
        //opens close frame class which lets the user to close the game
        if (source == closeButton){
            CloseFrame close = new CloseFrame();
        }
    }
}
