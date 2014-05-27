import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created on 5/26/2014.
 */
public class FileCreator {

    private String deckName;
    private File answerFile;
    private File questionFile;
    private int numberOfCards;

    /**
     * Determines if the file exists
     * if it does the overrideOption() is called and
     * also checks to see if the text-field isNameless()
     */
    public void checkFileExistance(){

        answerFile = new File("txt/"+deckName+"Answers.txt");
        questionFile = new File("txt/"+deckName+"Questions.txt");

        if(isNameless()==true){
            return;
        }
        if (!answerFile.exists() || !questionFile.exists()) {

            createFile();

        }else{
            overrideOption();
        }
    }

    /**
     *Prompts the user for
     * the option to either write over
     * the txt file with the same name
     * or try a different name.
     */
    private void overrideOption() {
        int reply = JOptionPane.showConfirmDialog(null, "One or more of these files already exist are you sure you " +
                "want to " +
                "write over them?", "Flash Card Wizard v0.1", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {

            createFile();
        }else{
            JOptionPane.showMessageDialog(null, "Try naming your flash card deck something else",
                    "Flash Card Wizard v0.1", JOptionPane.PLAIN_MESSAGE);


        }
    }

    /**
     * creates a file named answerFile and questionFile
     * with the deckName used as the first part of the name
     * and a postfix Questions.txt and Answers.txt
     * example: FlashCardsQuestions.txt
     * throws IOException and printsStackTrace()
     */
    public void createFile(){

        try{
            answerFile.createNewFile();
            questionFile.createNewFile();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *@return determines if the JTextField: deckName is empty
     * if it is a customized error message is thrown
     */
    public boolean isNameless(){

        if(deckName.equals(null)||deckName.equals("")){

            JOptionPane.showMessageDialog(null,"You cannot leave the name blank","Flash Card Wizard v0.1",
                    JOptionPane.ERROR_MESSAGE);

            return true;
        }

        return false;
    }

    /**
     *@param numberOfCards sets the numberOfCards to what the argument passed
     *for setting the number of cards outside of the DeckCreation class.
     */
    public void setNumberOfCards(int numberOfCards){

        this.numberOfCards= numberOfCards;

        }

    /**
     *@return gets number of cards
     */
    public int getNumberOfCards() {
        return numberOfCards;
    }

    /**
     *@param deckName sets the deckName via the argument passed
     *
     */
    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    /**
     *@return returns deckName
     */
    public String getDeckName() {
        return deckName;
    }

    /**
     *@return returns answerFile
     */
    public File getAnswerFile() {

        return this.answerFile;

    }

    /**
     *@return returns questionFile
     */
    public File getQuestionFile(){
        return this.questionFile;
    }
}

