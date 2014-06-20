import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created on 5/15/2014.
 */
public class FlashCardFrame extends JFrame {




    private CardImage image;
    private JTextArea area;
    private JButton writeFile;

    public void createFrame(){

        image = new CardImage();
        setLayout(new BorderLayout());
        setContentPane(image.getFlashCardImage());
        setLayout(new FlowLayout());
        add(questionAnswerArea());
        add(buttonContainer());
        setSize(512,306);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Flash Card Wizard v0.1");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        pack();

    }

    /**
     * @return returns a JPanel as a container holding a JButton: writeFile
     */
    private JPanel buttonContainer(){
       JPanel panel = new JPanel();
        writeFile = new JButton("Click to write cards down");
        //writeFile.addActionListener(new WriteFileButtonAction());
        panel.add(writeFile);

        return panel;
      }

    /**
     * @return returns  a JPanel as a container holding JTextArea: area
     */
    private JPanel questionAnswerArea(){
        JPanel panel = new JPanel();
        area = new JTextArea();
        area.setRows(12);
        area.setColumns(12);
        panel.add(area);
        return panel;
    }

    /**
     * @return returns the text from the JTextArea: area
     */
    public String getText(){

        String n = area.getText();
        return n;
    }

    /**
     * @param al method needed because of faulty design.
     *  In essence an out of class listener is being applied
     *  to the button
     *  Yes this is bad design I don't see it causing many issues down the road
     *  but I will have to remember to take this into consideration next time.
     */
    public void applyListener(ActionListener al){
        writeFile.addActionListener(al);
    }
}
