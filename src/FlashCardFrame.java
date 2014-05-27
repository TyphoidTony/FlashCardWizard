import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 5/15/2014.
 */
public class FlashCardFrame extends JFrame {


    private JTextField questionField;
    private FileCreator createFiles;
    private FileWriter writeToAnswers;
    private JTextField answerField;
    private CardImage image;
    public FlashCardFrame(){

        image = new CardImage();
        createFiles = new FileCreator();
        setLayout(new BorderLayout());
        setContentPane(image.getFlashCardImage());
        setLayout(new FlowLayout());
        add(questionField());
        add(answerField());
        setSize(512,306);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Flash Card Wizard v0.1");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        pack();

    }


    private JPanel questionField(){

        JPanel panel = new JPanel();
        questionField = new JTextField("Write your questions here",20);
        questionField.addActionListener(new WriteQuestionListener());
        panel.add(questionField);
        return panel;

    }

    private JPanel answerField(){
        JPanel panel = new JPanel();
        answerField = new JTextField("Write your answers here",20);
        answerField.addActionListener(new WriteAnswerListener());
        panel.add(answerField);
        return panel;
    }

    /**
     * trying to write txt to the answerFile
     * TODO get this working.
     */
    private void writeToAnswersFile(){

        try {
            writeToAnswers = new FileWriter((createFiles.getAnswerFile()));

            writeToAnswers.write(answerField.getText());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private class WriteQuestionListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

        //TODO create an action for this event.

        }
    }

    private class WriteAnswerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            writeToAnswersFile();
        }
    }
}



