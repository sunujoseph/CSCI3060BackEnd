
import java.io.*;
import java.util.*;
public class Accounts{

    String username;
    String user_type;
    float available_credit;

    MyFileReader myFileReader = new MyFileReader();

    ArrayList<String> stringList = new ArrayList<String>();
    ArrayList<User> usersList = new ArrayList<User>();
    File userFile = new File("current_user_accounts.txt");

    public Accounts(){
        
    }

    public void loginInfo(){

        myFileReader.setFile(userFile);
        stringList = myFileReader.getFileData();

        for (int i = 0; i < stringList.size(); i++) { 

        }



    }

    public void oldUserFile(){

    }

    public void newUserFile(){

    }

    



}