import javax.swing.*;

/**
 * Created on 5/5/2014
 * Created by Anthony Soto
 */

public class Main {
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlashOptionsWindow();
            }
        });

    }

}
