import javax.swing.*;
import java.io.*;

/**
 * Created on 5/26/2014.
 */
public class FileCreator {

    private String deckName;
    private int numberOfCards;
    private File flashCardFile;
    private FileWriter fileWriter;
    private String dir = "Q&ADir";
    private File mainDir;


    /**
     * Determines if the file exists
     * if it does the overrideOption() is called and
     * also checks to see if the text-field isNameless()
     */
    public void checkFileExistance(){

        flashCardFile = new File("C:/Q&ADir/"+deckName+".txt");

        if(isNameless()){
            return;
        }
        if (!flashCardFile.exists()) {

            createFile();

        }else{
            overrideOption();
        }
    }

    /**
     *  Prompts the user for
     * the option to either write over
     * the txt file with the same name
     * or try a different name.
     */
    private void overrideOption() {
        int reply = JOptionPane.showConfirmDialog(null, "One or more of these files already exist are you sure you " +
                "want to " +
                "write over them?", "Flash Card Wizard v0.1", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {

                    createOverride();
        }else{
            JOptionPane.showMessageDialog(null, "Try naming your flash card deck something else",
                    "Flash Card Wizard v0.1", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * deletes file if the user clicks "Yes" on the overrideOption() prompt
     * and then creates a new empty file with the same name.
     */
    private void createOverride(){
        flashCardFile.delete();
        try{
            flashCardFile.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
       }
    }

    /**
     * creates a file named answerFile and questionFile
     * with the deckName used as the first part of the name
     * and a postfix Questions.txt and Answers.txt
     * example: FlashCardsQuestions.txt
     * throws IOException and printsStackTrace()
     */
    private void createFile(){

        try{
            flashCardFile.createNewFile();

               }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * @return determines if the JTextField: deckName is empty
     * if it is a customized error message is thrown
     */
    private boolean isNameless(){

        if(deckName.equals(null)||deckName.equals("")){

            JOptionPane.showMessageDialog(null,"You cannot leave the name blank","Flash Card Wizard v0.1",
                    JOptionPane.ERROR_MESSAGE);

            return true;
        }

        return false;
    }

    /**
     * @param numberOfCards sets the numberOfCards to what the argument passed
     * for setting the number of cards outside of the DeckCreation class.
     */
    public void setNumberOfCards(int numberOfCards){

        this.numberOfCards= numberOfCards;

        }

    /**
     * @return gets number of cards
     */
    public int getNumberOfCards() {
        return numberOfCards;
    }

    /**
     * @param deckName sets the deckName via the argument passed
     *
     */
    public void setDeckName(String deckName) {
         this.deckName = deckName;

    }

    /**
     * @return returns deckName
     */
    public String getDeckName() {
        return deckName;
    }

   /**
     * @param n argument passed to assign the specific text to the file.
     * @throws IOException
     */
        public void writeToFile(String n) throws IOException{

          fileWriter = new FileWriter(flashCardFile,true);
          fileWriter.write(n);
          fileWriter.close();

        }

    /**
     * makes the directory
     */
     private void makeDir(){

         mainDir.mkdir();
     }

    /**
     *
     * @return returns true if the directory exists but false if not.
     * if it is false then the directory is made.
     */
    public void checkDir(){
        mainDir = new File(dir);

        if(!mainDir.exists()){

            makeDir();
        }
            return;
    }
}

