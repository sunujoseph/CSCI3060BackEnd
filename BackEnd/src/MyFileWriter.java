

import java.io.*;
import java.util.*;
public class MyFileWriter{

    public File currentFile;

    public MyFileWriter(){

    }

    public File getFile(){
        return currentFile;
    }

    public void setFile(File file){
        currentFile = file;
    }

    public void FileWriting(ArrayList<String> stringList) throws IOException {
        FileWriter writer = new FileWriter(currentFile);
        for (int i = 0; i < stringList.size(); i++) {
            writer.write(stringList.get(i) + System.lineSeparator());
            //System.out.println(stringList.get(i));
            // System.out.println(stringList.get(i).length());
        }
        writer.close();

    }

}