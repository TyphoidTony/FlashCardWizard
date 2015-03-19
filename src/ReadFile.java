import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created on 6/29/2014.
 */
public class ReadFile{


    /**
     * This file will be used to read the file that was opened
     * and populate an array list with both answers and questions.
     */

       private Path path;
       private ArrayList<String> QA;//questions and answers variable

    /**
     * opens and reads the selected file
     * then dumps the text into an array
     */
    public void readDump(File file) {
        QA = new ArrayList<>();
        String data;
        int len = QA.size();
        path = file.toPath();

        try(BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())){

            while((data = reader.readLine())!=null){
                QA.add(len-1,data);
                len++;
            }

        }catch(IOException IOE) {
            IOE.printStackTrace();
        }
    }

}
