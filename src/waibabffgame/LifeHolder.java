/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waibabffgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 *
 */
public class LifeHolder extends Sprite {

    private String lifeh = "Pictures/Ninja/LifeHolder.png";
    private boolean visible;
    private Image image;
    private Image barimage;
    int Health = 200;
    private int bx = 0;
    private int by = 0;

    public LifeHolder() {
        //This thing holds the HP bars
        ImageIcon Holder = new ImageIcon(this.getClass().getResource(lifeh));
        image = Holder.getImage();
        setWidth(image.getWidth(null));
        setHeight(image.getHeight(null));
        setImage(image);

        ImageIcon BarImage = new ImageIcon(lifeh);
        barimage = BarImage.getImage();

        visible = true;
        x = 10;
        y = 10;
        setX(x);

        setY(y);

        bx = 31;
        by = 45;


    }

    public Image getBarImage() {
        return barimage;

    }

    public void act() {

        if (Health < 0) {
            Health = 0;
        }
        //Gets the bar referred to in Game
      
        barimage = Game.barI[Health].getImage();
    }
    //Functions: Most are pretty self-explanitory

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public void lowerHealth(int health) {
        Health -= health;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, this.getWidth(), this.getHeight());
    }

    public void setbX(int x) {
        this.bx = x;
    }

    public void setbY(int y) {
        this.by = y;
    }

    public int getbY() {
        return by;
    }

    public int getbX() {
        return bx;
    }
}
