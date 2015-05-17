/**
 * Created on 5/13/2014.
 * File chooser menu class
 */

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooser{

    private JFileChooser  chooser;
    private File selectedFile;
    private ReadFile readFile;
    private FileFilter cFilter;

    /**
     * starts a JFileChooser window
     * and opens files
     */
       public void showFileChooser(){

       readFile = new ReadFile();
       chooser = new JFileChooser();
       cFilter = new FileNameExtensionFilter("txt ",new String[]{"txt"});
       chooser.setFileFilter(cFilter);
       chooser.setDialogTitle("Flash Card Wizard v0.1");
       int getFile = chooser.showOpenDialog(null);

      if(getFile == JFileChooser.APPROVE_OPTION) {

          selectedFile = chooser.getSelectedFile();

            if(checkFile(getSelectedFile().getName())){
               readFile.readDump(getSelectedFile());
                 }
        }
    }

    /**
     * @return returns selected file from file chooser
     */
    public File getSelectedFile(){
                return selectedFile;
        }

    /**
     * @param file takes type file
     * @return Returns false if the extension
     * is not a .txt file
     */
    private boolean checkFile(String file){

            file.split(".");
            if(file.contains("txt")) {
                return true;
            }

     JOptionPane.showMessageDialog(null, "You can only open text files try again",
                        "FILE TYPE ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }










