import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created on 5/14/2014.
 */
public class DeckCreation  extends JFrame {


    private JTextField flashCardName;
    private JLabel flashCards;
    private JTextField cardAmount;
    private JLabel amount;
    private FileCreator create;
    private CardImage image;


    public DeckCreation() {

        image = new CardImage();
        create = new FileCreator();
        setLayout(new BorderLayout());
        setContentPane(image.getFlashCardImage());
        setLayout(new FlowLayout());
        add(cardAmountPanel());
        add(deckNamePanel());

        setVisible(true);
        setSize(512,306);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Flash Card Wizard v0.1");

        setResizable(false);
        setLocationRelativeTo(null);
        pack();

    }


    private JPanel cardAmountPanel(){
        JPanel panel = new JPanel();
        amount = new JLabel("Enter how many cards you want");
        cardAmount = new JTextField(5);
        cardAmount.addActionListener(new CardNumberListener());
        panel.add(amount);
        panel.add(cardAmount);
        return panel;
    }

    /**
     *@return returns a JPanel as a container
     * holding the components: flashCardName and flashCards
     */
    private JPanel deckNamePanel(){
        JPanel panel = new JPanel();
        flashCardName = new JTextField(10);
        flashCards = new JLabel("Enter the name of your Deck here");
        flashCardName.addActionListener(new DeckNameListener());
        panel.add(flashCards);
        panel.add(flashCardName);

        return panel;
    }

    /**
     * assigns deckName based on the string from the
     * JTexField FlashCardName after assigning it deckName
     * it then checks to see if the file already exists
     *
     */

    private void CreateFlashCardDeck(){
        create = new FileCreator();
        create.setDeckName(flashCardName.getText());
        create.checkFileExistance();

    }

    /**
     *@return attempts to parse the text from the cardAmount textField
     * if it can not it returns false.
     * if it can than the numberOfCards is passed as an argument
     * to the setNumberOfCards method in the FileCreator class
     */
    private boolean parseNumberOfCards(){
        String text = cardAmount.getText();
        int n;
        try {
            n = Integer.parseInt(text);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"that is not a a valid number please try again",
                    "Flash Card Wizard v0.1",JOptionPane.ERROR_MESSAGE);
            return false;
        }
            create.setNumberOfCards(n);
            return true;
    }



    private class DeckNameListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateFlashCardDeck();
    }
}
    private class CardNumberListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {


            if(parseNumberOfCards() == false){
                return;
            }
            new FlashCardFrame();

        }
    }
}
