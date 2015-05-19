import javax.swing.*;

/**
 * This is an absolute JFrame class
 * made to stop having to repeat a lot of the
 * very pointless lines of code in every other
 * class that extends JFrame
 * any general modifications to the window over all
 * should be made here. General meaning
 * 'things' every frame will have in them by default
 *
 * These defaults can of course be overridden
 * with no need to modify this class itself
 *
 * Created on 5/19/2015.
 * Created by Anthony Soto
 */

public class FlashMainFrame extends JFrame {


    public FlashMainFrame(){
        setTitle("Flash Card Wizard");
        setLocationRelativeTo(null);
        setResizable(false);

    }

}
