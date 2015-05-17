import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;

import javax.swing.*;
import java.io.BufferedReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created on 5/17/2015.
 */
public class AboutPage extends JFrame {

    private JTextArea textAbout;
    private File fileAbout;
    private Path path;

    public AboutPage(){

        setSize(500,100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("FlashCard Wizard");
        readFile();
        add(readFile());
        setLocationRelativeTo(null);
    }

    private JTextArea readFile(){

        String read = null;
        textAbout = new JTextArea();
        textAbout.setEditable(false);
        fileAbout = new File("src/About.txt");
        path = fileAbout.toPath();
        textAbout.setLineWrap(true);
          try(BufferedReader reader = Files.newBufferedReader(path,Charset.defaultCharset())){

               while((read = reader.readLine())!=null){
                   textAbout.append(read);

                }

                }catch(IOException e){
                e.printStackTrace();
              }

        return textAbout;


    }


}

