/**
 * Created on 5/13/2014.
 */
import javax.swing.*;

public class FileChooser{

   public FileChooser(){

       //TODO file name extension filter of some kind (maybe)

       JFileChooser  chooser = new JFileChooser();
       chooser.setDialogTitle("Flash Card Wizard v0.1");
       int get = chooser.showOpenDialog(null);






   }



}
