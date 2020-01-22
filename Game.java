
/**
 * Class that creates the main game containing two JPanels.
 *
 * @HIOI CHING NG
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class Game extends JFrame
{
    private JFrame frame;
    
    public Game()
    {
        super("Gold Picker");
        setSize(900,600);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        setVisible(true);
        makeFrame();
    }
    
    public void makeFrame()
    {
      GoldPicker panelone = new GoldPicker();

      panelone.init();
      panelone.setSize(700, 500);
      panelone.setMinimumSize(panelone.getSize());
      panelone.setBackground(Color.YELLOW);
      StatusPanel paneltwo = new StatusPanel();
      paneltwo.setSize(200,500);
      paneltwo.setLocation(700,0);
      paneltwo.setMinimumSize(paneltwo.getSize());
      paneltwo.setBackground(Color.BLACK);
  
       
      // set the frame to exit when it is closed
      add(panelone);
      add(paneltwo);
      // add the panel to the frame      
     
      setVisible(true); // make the frame visible  
      
      
    }
    
    public void restartclose(){
        setVisible(false);
    }
}
