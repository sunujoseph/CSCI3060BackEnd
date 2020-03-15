
/*
*   Interacts with FileReader.java
*   Interacts with Item.java 
*   Reads the available items.txt
*   Stores within a item ArrayList
*   Item Class ArrayList used for credit computation, formating and matching
*/
import java.io.*;
import java.util.*;
public class UserActivity{

    String item_name;
    String sellers_username;
    String winning_user;
    int num_days;
    float current_bid;

    MyFileReader myFileReader = new MyFileReader();
    String location = System.getProperty("user.dir");
    String file = location + "\\CSCI3060BackEnd\\BackEnd\\src\\available items.txt";
    File itemFile = new File(file);


    
    ArrayList<Item> itemList = new ArrayList<Item>();

    public UserActivity(){

    }

    public void itemData(){
        
    }

    public void oldItemsFile(){

    }
    public void newItemsFile(){

    }


}