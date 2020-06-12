/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waibabffgame;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class Buttons extends JPanel implements MouseListener {

    int test = 0;
    private String Button;
    private String back = "Pictures/Start.png";
    private int dx;
    private int dy;
    private int mx;
    private int my;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    Image Original;

    public Buttons() {
        //Buttons! The strangest, most unnecessarily difficult way I thought of to make a button, all put into one class!
        ImageIcon ButtonI = new ImageIcon(this.getClass().getResource(back));
        image = ButtonI.getImage();
        //Set image
        setImage(image);

        visible = true;
        //Set Location
        mx = 650;
        my = 300;
        //Width, Height
        height = (image.getHeight(null));
        width = (image.getWidth(null));

        this.setBounds(mx, my, width, height);

    }
    //Most of these functions are pretty self-explanitory
    //Set Image

    public void setImage(Image image) {
        this.image = image;
        height = (image.getHeight(null));
        width = (image.getWidth(null));
        Original = image;
    }

    public Image getImage() {
        return image;
    }

    public String getButton() {
        return Button;
    }

    public void setButton(String e) {
        Button = e;
    }

    public void mouseClicked(MouseEvent e) {
    }

    //Mouse PRessed
    public void mousePressed(MouseEvent e) {

        //If statements with unnecessarily hard math

        if (this.getButton().equals("Level Select") && Game.mmenu == true && (e.getX() / Game.awidth) > mx && (e.getX() / Game.awidth) <= (mx + width) && e.getY() > my / Game.aheight && e.getY() <= (my + height) / Game.aheight) {
            //Change background
            Game.CSaveDataPrompt = false;
            Game.CSaveDataCleared = false;
            Game.MenuToLS = true;
            Button = "";
            //Remove this button

            Game.buttons.remove(0);


            this.removeMouseListener(this);



        }

        if (this.getButton().equals("Clear Data") && Game.mmenu == true && (e.getX() / Game.awidth) > mx && (e.getX() / Game.awidth) <= (mx + width) && e.getY() > my / Game.aheight && e.getY() <= (my + height) / Game.aheight) {
       
            Game.CSaveDataPrompt = true;
            Game.CSaveDataCleared = false;

        }




        //Start Game button
        if (this.getButton().equals("Start Game") && Game.levelselect == true && Game.Locked[Game.CurrentLevel] == false && (e.getX() / Game.awidth) > mx && (e.getX() / Game.awidth) <= (mx + width) && e.getY() > my / Game.aheight && e.getY() <= (my + height) / Game.aheight) {
            //Change background


           
            Button = "";

            //Remove this button
            // Game.images.remove(0);


            if (Game.CurrentLevel == 0) {
                Game.TutorialEvent = 1;
            } else if (Game.CurrentLevel == 1) {
                Game.WatermelonEvent = 0;

            } else if (Game.CurrentLevel == 2) {
                Game.StrawberryEvent = 0;
            } else if (Game.CurrentLevel == 3) {
                Game.OrangeEvent = 0;
            } else if (Game.CurrentLevel == 4) {
                Game.GrapeEvent = 0;
            } else if (Game.CurrentLevel == 5) {
                Game.BananaEvent = 0;
            } else if (Game.CurrentLevel == 6) {
                Game.MangoEvent = 0;
            } else if (Game.CurrentLevel == 7) {
                Game.AppleEvent = 0;
            }

            Game.ActivateGame = true;


        }

        if (this.getButton().equals("Right Level") && (e.getX() / Game.awidth) > mx && (e.getX() / Game.awidth) <= (mx + width) && e.getY() > my / Game.aheight && e.getY() <= (my + height) / Game.aheight) {
            Game.RightLevel = true;


        }
        if (this.getButton().equals("Left Level") && (e.getX() / Game.awidth) > mx && (e.getX() / Game.awidth) <= (mx + width) && e.getY() > my / Game.aheight && e.getY() <= (my + height) / Game.aheight) {
            Game.LeftLevel = true;


        }


    }

    public void mouseReleased(MouseEvent e) {
        //System.out.println("test");
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void setbWidth(int _width) {

        this.width = _width;
    }

    public int getbWidth() {

        return width;

    }

    public void setbHeight(int _height) {

        this.height = _height;
    }

    public int getbHeight() {

        return height;

    }

    public void setmX(int x) {
        this.mx = x;
    }

    public void setmY(int y) {
        this.my = y;
    }

    public int getmY() {
        return my;
    }

    public int getmX() {
        return mx;
    }
}
