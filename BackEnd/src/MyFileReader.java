
import java.io.*;
import java.util.*;
public class MyFileReader{

    public File currentFile;

    public MyFileReader(){

    }

    public File getFile(){
        return currentFile;
    }

    public void setFile(File file){
        currentFile = file;
    }

    public ArrayList<String> getFileData(){

        ArrayList<String> data = new ArrayList<String>();

        try {
            Scanner fileReader = new Scanner(currentFile);
            while(fileReader.hasNextLine()){
                data.add(fileReader.nextLine())  ;

            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            //TODO: handle exception
            System.out.println("ERROR!");
            e.printStackTrace();
        }   

        return data;

    }

}