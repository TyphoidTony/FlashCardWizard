import javax.swing.*;

/**
 * Created on 5/27/2014.
 */
public class CardImage {

    /**
     *@return returns the JLabel that is used to display the
     * flash card image on all of the JFrames
     */
    public JLabel getFlashCardImage(){

        ImageIcon card = new ImageIcon("art/card.png");
        JLabel cardLabel = new JLabel(card);
        cardLabel.setOpaque(true);
        return cardLabel;
    }

}
