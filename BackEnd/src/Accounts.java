/*
*           ACCOUNTS CLASS
* This class reads in both old and new user files. The user class
* feeds in information regarder a deleted/new user/changed privilege and changes 
* the necessary information into the old user file. Reads the current_user_accounts.txt.
*   Stores within a User ArrayList. User Class ArrayList used for credit computation, formating and matching.
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
        oldUserFile();
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


    public void addCurrentUserCredit(String name, String type, String credit){
        User creditUser = new User(name, type, credit);
        for (int i = 0; i < usersList.size(); i++) { 
            if(usersList.get(i).userName.equals(creditUser.userName)){
                usersList.get(i).userCredit = creditUser.userCredit;
                break;
                //System.out.println(usersList.get(i).currentUsersFileFormat());
            }
        }
    }

    public void newUserFile(String name, String type, String credit){
        User newUser = new User(name, type, credit);
        User temp = usersList.get(usersList.size()-1);//store end in temp
        
        usersList.remove(usersList.size() - 1); //remove END
        stringList.remove(stringList.size()-1);
        usersList.add(newUser); // new user line
        String listElement = usersList.get(usersList.size()-1).currentUsersFileFormat();
        stringList.add(listElement);
        stringList.add("END"); // add new END line at the end
        usersList.add(temp); // end line

        

        //file creation here
    }


    public void deleteUserFile(String name, String type, String credit){
        User deleteUser = new User(name, type, credit);
        User temp = usersList.get(usersList.size()-1);//store end in temp
        
        usersList.remove(usersList.size() - 1); //remove END
        stringList.remove(stringList.size()-1); //remove End
        for (int i = 0; i < usersList.size(); i++) { 
            if(usersList.get(i).userName.equals(deleteUser.userName)){
                usersList.remove(i);
                stringList.remove(i);
                break;
            }
            //System.out.println(usersList.get(i).currentUsersFileFormat());
        }
        stringList.add("END"); // add new END line at the end

        

        //file creation here
    }
    



}
