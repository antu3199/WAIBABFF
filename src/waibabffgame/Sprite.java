/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waibabffgame;

/**
 *
 * @author Anthony Tu
 */
import java.awt.Image;

public class Sprite {
    //Common variables and functions amongst all object classes - most are pretty self-explanitory

    private boolean visible;
    private Image image;
    protected int x;
    protected int y;
    private boolean dying;
    protected int dx;
    private int width;
    private int height;

    public Sprite() {
        visible = true;
    }

    public void die() {
        visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    protected void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setImage(Image image) {
        this.image = image;

    }

    public Image getImage() {
        return image;
    }

    public void setWidth(int _width) {

        this.width = _width;
    }

    public int getWidth() {

        return width;

    }

    public void setHeight(int _height) {

        this.height = _height;
    }

    public int getHeight() {

        return height;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
    }

    public boolean isDying() {
        return this.dying;
    }
}
