/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waibabffgame;

/**
 *
 * @author Anthony Tu
 */
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * 
 */
//Main Class of the Game. Initializes the UI and starts the game.
public class Main extends JFrame {

    public Main() {

        initUI();
    }

    private void initUI() {
//Creates the game
        add(new Game());
        int testw = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
        int testh = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        pack();
        validate();
        setSize((int) (testh / 0.7080078125), testh);
        if (testh > 725) {
            setSize(1024, 725);
        }
        //Sets the title of the program
        setTitle("WHY AM I BEING ATTACKED BY FLYING FRUIT???");
        //Create an exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
    }

    //Runnable- meaning actually does stuff
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                //Create the program
                Main ex = new Main();
                //Set it visible
                ex.setVisible(true);
            }
        });
    }
}
