
/**
 * Goldpicker creates random rectangles (one with golden ratio), and when user
 * clicks the retangles, it shows if the user clicked the correct one. 
 *
 * @Hoi Ching Ng
 * @version 1
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class GoldPicker extends JPanel
implements MouseListener, MouseMotionListener
{
    //Arrays that store rectangle sizes
    private int[] heights;
    private int[] widths;
    //Arrays that store coordinates of rectangles
    private int[] rectx;
    private int[] recty;
    private boolean golden = false;
    public static int score = 0;
    public static int clickedx, clickedy, attempt;
    public static int lives = 3;
    private JLabel scores, attempts;
    private static Color currentColor;

    private boolean xbounds, ybounds;
    private String Name;
    private boolean isFirstTime;
    private boolean overlap = true, bounds = true;
    public static int level;

    private ArrayList<Color> COOLColors = new ArrayList<Color>();

    /**
     * Set up rectangle attributes, which are sizes, locations,and color. And also adding the mouselistener
     */
    public void init() //initialize values
    {
        heights = new int[6];
        widths = new int[6];
        rectx = new int[6];
        recty = new int[6];

        attempt = 0;

        /**
         * Draw rectangles and add random spacing between them
         * 
         */

        heights[0] = randomizeheight();
        widths[0] = (int)(Math.sqrt(5) + heights[0])/2;
        genRectSize();
        genRectLocation();

        for (int i = 1; i<5; i++){
            genRectSize();
            genRectLocation();
        }

        /**
         * add mouse listeners
         */
        addMouseListener(this);
        addMouseMotionListener(this);


        COOLColors.add(new Color (5,56,107));
        COOLColors.add(new Color (55,150,131));
        COOLColors.add(new Color (92,219,107));
        COOLColors.add(new Color (142,228,175));
        COOLColors.add(new Color (237,245,225));
    }

    /**
     * Draws golden rectangle size by randomization
     */
    public void genRectSize(){
        for (int i = 1; i<5;i++){ 
            heights[i] = randomizeheight();
            widths[i] = randomizewidth();
        }
    }

    /**
     * Draws golden rectangle size
     */
    public void genRectLocation(){
        for (int i = 0; i<5;i++){ 
            rectx[i] = randomizeXcoord();
            recty[i] = randomizeYcoord();
        }
    }

    
    /**
     * Draws graphics component
     */
    @Override
    public void paintComponent(Graphics bg)
    {
        super.paintComponent(bg);

        //Draw title string
        Font title = new Font("Courier", Font.BOLD,25);
        bg.setFont(title);
        bg.drawString("Welcome to Gold Picker, " + WelcomePage.getNames() ,100,40);

        //customise color for border
        Color PurpleBorder = new Color (226, 145, 250); 
        //Draw border
        Graphics2D g2d = (Graphics2D) bg;
        g2d.setColor(PurpleBorder);
        g2d.setStroke(new BasicStroke(4));
        g2d.draw(new Rectangle2D.Double (20, 20, 660, 460));

        //Draws rectangles
        for (int i = 0; i < 5 ; ++i)
        {
            
            currentColor = COOLColors.get(randomColorArray());// randomized number is used to select which is color is used to fill rectangle
            bg.setColor(currentColor);
            bg.fillRect(rectx[i], recty[i], heights[i], widths[i]);
        }

        /*
        if (golden == true)
        {
        for (int i = 0; i < 5 ; ++i)
        {
        bg.clearRect(rectx[i], recty[i], heights[i], widths[i]);
        }
        }
         */

    }

    /**
     * Randomizes number from 0-4,
     */
    public int randomColorArray(){
        int c = (int)(Math.random() * 4);
        return c;
    }

    /**
     * Update the score, increments when correct rectangle is clicked. If score reached to 10, ends the game.
     */
    public void updateScore()
    {
        if (golden == true)
        {
            score++;
        }

        if (score == 10){
            EndLevel end = new EndLevel();
        }
    }

    /**
     * Update lives, decreases if clicked wrong rectangle, ends level if lives reaches to 0.
     */
    public void updatelives(){
        if (golden == false){
            lives--;
        }

        if (lives == 0){
            EndLevel end = new EndLevel(); 
        }
    }

    /**
     * Randomize height of rectangles within the range of 40 to 100 pixels
     */
    public int randomizeheight()
    {
        //set range: Math.random * ((max - min) + 1)  + min) 
        int h = (int) (Math.random()*((100 - 40) + 1)) + 40;
        return h;
    }

    /**
     * Randomize width of rectangles within the range of 40 to 100 pixels
     */
    public int randomizewidth()
    {
        Random randomheight = new Random();
        int w = (int)(Math.random()*((100 - 40) + 1)) + 40;
        return w;
    }

    /**
     * Randomize x coordinate of rectangles within the range of 30 to 500 pixels
     */
    public int randomizeXcoord()
    {
        int i, x;
        x =(int)(Math.random() * ((500 - 30) + 1 ))+30;
        return x;
    }

    /**
     * Randomize y coordinate of rectangles within the range of 100 to 300 pixels
     */
    public int randomizeYcoord()
    {
        int y = (int)(Math.random() * ((300 - 100) + 1 ))+100;
        return y;
    }

    /**
     * Randomize y coordinate of rectangles within the range of 50 to 80 pixels
     */
    public int randomizeSpacing()
    {
        int s = (int)(Math.random() * ((80 - 50) + 1) + 50);
        return s; 
    }

    public void mousePressed( MouseEvent e ){}

    /**
     * Create mouse event when clicked
     */

    public void mouseClicked (MouseEvent e){
System.out.println("Clicked at " + e.getX() + "," + e.getY());
        //if statement to see if the clicked x coordinate is in the golden rectangle
        if (rectx[0] <= e.getX() && e.getX() <= (rectx[0] + widths[0]))
        {
            //if statement to see if the clicked y coordinate is in the golden rectangle
            if (recty[0] <= e.getY() && e.getY() <= (recty[0] + heights[0]))
            {
                //notify user when clicked the right one by printing a message
                System.out.println("Clicked golden rectangle");
                golden = true;

            }
        }
        else 
        {
            //notify user when clicked the wrong one by printing a message
            System.out.println("not the golden rectangle, try again!");
            golden = false;
            
        }
        //if the game is in score mode, ends the game ONLY when the score reaches to 10
        if (StatusPanel.getisScoreMode() == true){
            updateScore();
        }
        //if the game is in survival, ends game ONLY when lives reaches to 0
        if (StatusPanel.getisScoreMode() == false){
            updatelives();
            score++;
        }
        //generates the rects again after each click
        genRectSize();
        genRectLocation();
        //updates JLabels displaying the score in StatusPanel
        StatusPanel.refreshLabels();
        repaint();
    }

    public void mouseExited( MouseEvent e ){}

    public void mouseDragged( MouseEvent e ){}

    public void mouseMoved( MouseEvent e ){}

    public void mouseEntered( MouseEvent e ){}

    public void mouseReleased( MouseEvent e ){}

   

    public static int getAttempts()
    {
        return GoldPicker.attempt;
    }

    public static int getScore()
    {
        return GoldPicker.score;
    }

    public static int getlives()
    {
        return GoldPicker.lives;
    }

}
