/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waibabffgame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * 
 */
public class GameBackground extends Sprite {

    private String back = "Pictures/Other/loading.png";
    private int dx;
    private int dy;
    private int x;
    private int y;
    private boolean visible;
    private Image image;

    public GameBackground() {
        //Image
        ImageIcon Background = new ImageIcon(this.getClass().getResource(back));
        image = Background.getImage();
        //Width, height
        setWidth(image.getWidth(null));
        setHeight(image.getHeight(null));
        setImage(image);

        visible = true;
        //x, y
        x = 0;
        y = 0;
        setX(x);
        setY(y);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, this.getWidth(), this.getHeight());
    }
}
