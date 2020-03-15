/*
*   Interacts with User.java 
*   Reads the current_user_accounts.txt
*   Stores within a User ArrayList
*   User Class ArrayList used for credit computation, formating and matching
*/
import java.io.*;
import java.util.*;
public class Accounts{

    String username;
    String user_type;
    float available_credit;

    MyFileReader myFileReader = new MyFileReader();

     ArrayList<String> stringList = new ArrayList<String>();
     ArrayList<User> usersList = new ArrayList<User>();

    String location = System.getProperty("user.dir");
    String file = location + "\\CSCI3060BackEnd\\BackEnd\\src\\current_user_accounts.txt";
    File userFile = new File(file);

    public Accounts(){
        oldUserFile();;
    }

    public void loginInfo(){

    }

    //check current file
    public void oldUserFile(){
        myFileReader.setFile(userFile);
        stringList = myFileReader.getFileData();

        for (int i = 0; i < stringList.size(); i++) { 
            if(stringList.get(i).equals("END")){
                break;
            }
            String name = stringList.get(i).substring(0,15);
            String type = stringList.get(i).substring(16,18);
            String credit = stringList.get(i).substring(19);
            User user = new User(name, type, credit);
            usersList.add(user);
        }

    }

    public void newUserFile(String name, String type, String credit){
        User newUser = new User(name, type, credit);
        
        usersList.remove(usersList.size() - 1); //remove END
        usersList.add(newUser); // new user line

        for (int i = 0; i < usersList.size(); i++) { 
            String listElement = usersList.get(i).currentUsersFileFormat();
            stringList.add(listElement);
            //System.out.println(usersList.get(i).currentUsersFileFormat());
        }
        stringList.add("END"); // add new END line at the end

        //file creation here
        


    }

    



}