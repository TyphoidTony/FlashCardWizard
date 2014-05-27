import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashOptionsWindow extends JFrame{

    private JButton newSet;
    private JButton openSet;
    private CardImage image;

    public FlashOptionsWindow(){

        image = new CardImage();
        setLayout(new BorderLayout());
        setContentPane(image.getFlashCardImage());
        setLayout(new GridBagLayout());
        add(openSetPanel());
        add(newSetPanel());
        setSize(512, 306);
        setTitle("Flash Card Wizard v0.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    /**
     *@return returns a JPanel that acts as container holding the newSet button
     */
    private JPanel newSetPanel(){
        JPanel panel = new JPanel();
        newSet = new JButton("new flash cards set");
        newSet.addActionListener(new NewSetListener());
        panel.add(newSet);
        return panel;
    }

    /**
     *@return returns a JPanel that acts as container holding the openSet button
     */
    private JPanel openSetPanel(){
        JPanel panel = new JPanel();
        openSet = new JButton("open flash card set");
        openSet.addActionListener(new OpenSetListener());
        panel.add(openSet);
        return panel;
    }


    private class OpenSetListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

           new FileChooser();

        }
    }

    private class NewSetListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            dispose();
            new DeckCreation();

        }
    }
}

