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


    ArrayList<String> stringList = new ArrayList<String>();
    ArrayList<Item> itemList = new ArrayList<Item>();

    public UserActivity(){
        oldItemsFile();

    }

    public void itemData(){
        
    }

    public void oldItemsFile(){
        //IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_DDD_PPPPPP
        myFileReader.setFile(itemFile);
        stringList = myFileReader.getFileData();

        for (int i = 0; i < stringList.size(); i++) { 
            if(stringList.get(i).equals("END")){
                break;
            }
            String itemName = stringList.get(i).substring(0,20);
            String seller = stringList.get(i).substring(21,36);
            String buyer = stringList.get(i).substring(37,51);
            String days = stringList.get(i).substring(52,55);
            String bid = stringList.get(i).substring(56);
            //System.out.println("~"+itemName+"~"+seller+"~"+buyer+"~"+days+"~"+bid);
            Item item = new Item(itemName,seller,buyer, days, bid);
            itemList.add(item);
            //System.out.println(itemList.get(i).getItemName());
        }
    }

    public void newItem( String itemName,String seller, String days, String bid){
        //item1               admin1          userBS         098 134.00
        //IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_DDD_PPPPPP
        //03_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSS_DDD_PPPPPP
        String buyer = "               "; // no buyer yet so blank
        //String buyer = "UUUUUUUUUUUUUUU";
        Item newItem = new Item(itemName,seller,buyer,days,bid);
        Item temp = itemList.get(itemList.size()-1);//store end in temp

        itemList.remove(itemList.size() - 1); //remove END
        stringList.remove(stringList.size()-1); //remove end
        itemList.add(newItem); // new user line
        String listElement = itemList.get(itemList.size() - 1).currentItemsFileFormat();
        stringList.add(listElement);
        itemList.add(temp);
        stringList.add("END"); // add new END line at the end
       

        for (int i = 0; i < stringList.size(); i++) { 
            
            System.out.println(stringList.get(i));
            //System.out.println(stringList.get(i).length());
        }
        //System.out.println("===============================");

    }

    public void newItemsFile(){

    }


}
