import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
/**
 * Write a description of class CloseFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CloseFrame extends JFrame
implements ActionListener
{
    // instance variables - replace the example below with your own
    private JLabel finish;
    private JButton yesButton, noButton, restartButton; 

    /**
     * Constructor for objects of class CloseFrame
     */
    public CloseFrame()
    {
        super("Close Game?"); 
        setSize(250,300); //horizontally, vertically
        this.setLayout(new FlowLayout(10,10,10));
        makeFrame();
        setVisible(true); 
    }

    public void makeFrame(){
        finish = new JLabel("Are you sure you want to quit?");
        
        yesButton = new JButton("Yes");
        
        noButton = new JButton("No");
        restartButton = new JButton("Restart Game");
        
        add(finish);
        add(yesButton);
        add(noButton);
        add(restartButton);
        
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        restartButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();
        if (source == yesButton)
        {
            System.exit(0);
        }

        if (source == noButton)
        {
            this.dispose();
        }
        
        if (source == restartButton){
            this.dispose();
            WelcomePage welcome = new WelcomePage();
        }
    }
}
