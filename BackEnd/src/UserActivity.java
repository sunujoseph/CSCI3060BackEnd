/*              
*           USER ACTIVITY CLASS
* This class applies all transactions to the Old Available Items File 
* to produce the New Available Items File.
* It reads the transactions that are made through the transaction class and 
* prints its necessary changes into the old items file. 
* In order for another user to have access to its new changes, the item class
* calls this class to obtain either its name, buyer, seller or bid amount. 
* Item Class ArrayList used for credit computation, formating and matching.
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
