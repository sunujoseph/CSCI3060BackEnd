/*
*       MYFILEREADER CLASS
* This class sends info and data from new/old items and account file
* into three classes: Transactions, UserActivity and Accounts. 
* Those three classes call MyFileReader for a certain database file 
* and it reads in "currentFile", transfers it to the data ArrayList in order
* to read in what is necessary. Then outputs each line of the file into a String ArrayList.
*/

import java.io.*;
import java.util.*;
public class MyFileReader{

    public File currentFile;

    public MyFileReader(){

    }

    public File getFile(){
        return currentFile;
    }

    public void setFile(final File file){
        currentFile = file;
    }

    public ArrayList<String> getFileData(){

        final ArrayList<String> data = new ArrayList<String>();

        try {
            final Scanner fileReader = new Scanner(currentFile);
            while(fileReader.hasNextLine()){
                data.add(fileReader.nextLine())  ;

            }
            fileReader.close();
        } catch (final FileNotFoundException e) {
            //TODO: handle exception
            System.out.println("ERROR!");
            e.printStackTrace();
        }   

        return data;

    }

	

}
