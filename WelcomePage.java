import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * This class introudces the user to the game, letting the user to select if they want to enter the game or 
 * read the instructions.
 *
 * @HOI CHING NG 
 * 
 */
public class WelcomePage extends JFrame 
implements ActionListener
{
    private JLabel questionLabel;
    private JTextField answer;
    private JButton okButton;
    private JButton Instructions, EnterGame;
    private JLabel greetingLabel;
    public static String name;
    
    
    /**
     * Constructor for Welcome Page, which is the page where user enters his/her name.
     */
    public WelcomePage(){
        super("Gold Picker Game"); //Add title to window
        setSize(300,300); //set window size horizontally, vertically
        setLayout(new FlowLayout()); 
        makeFrame();
        setVisible(true);
    }
    
    /**
     * Accessor method for getting string variable name to be passed into GoldPicker class.
     */
    public static String getNames()
    {
        return WelcomePage.name;
    }

    /**
     * Method that contain all components for JFrame.
     */
    public void makeFrame()
    {
        questionLabel = new JLabel("What is your name?");
        answer = new JTextField(15);

        okButton = new JButton("That's my name!");

        greetingLabel = new JLabel(""); 

        Instructions = new JButton("Instructions");
        Instructions.setVisible(false);
        
        EnterGame = new JButton("Enter Game");
        EnterGame.setVisible(false);
        
        JButton c_Bright = new JButton("Bright Theme");
        JButton c_Earth = new JButton("Earth Theme");
        JButton c_Cool = new JButton("Cool Theme");

        add(questionLabel);
        add(answer);
        add(okButton);
        add(greetingLabel);
        add(EnterGame);
        add(Instructions);
        
        
        //adds actionlistener to JButtons
        okButton.addActionListener(this);
        EnterGame.addActionListener(this);
        Instructions.addActionListener(this);
        
    }

    /**
     * Method of actions to be excuted after button clicks.
     */
    public void actionPerformed(ActionEvent f) 
    {
        Object source = f.getSource(); 
        
        if (source == okButton) {
            name = answer.getText();
            String greet = "Welcome " + name;
            greetingLabel.setText(greet);
            
            //create buttons which allows the user to either enter the game or read instructions
            EnterGame.setVisible(true);
            Instructions.setVisible(true);
            okButton.setVisible(false);
        }
        //open instructions panel if clicked
        if (source == Instructions){
            Instructions instructPanel = new Instructions();
        }
        //enter game if clicked
        if (source == EnterGame){
            Game Game1 = new Game();
            dispose();
        }
        
    }

    
}
