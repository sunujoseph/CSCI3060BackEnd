
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

public class UserActivity {

    String item_name;
    String sellers_username;
    String winning_user;
    int num_days;
    float current_bid;

    MyFileReader myFileReader = new MyFileReader();
    String location = System.getProperty("user.dir");
    //String file = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/available items.txt"

    File itemFile = new File(location + "\\CSCI3060BackEnd\\BackEnd\\src\\available items.txt");

    ArrayList<String> stringList = new ArrayList<String>();
    ArrayList<Item> itemList = new ArrayList<Item>();

    public UserActivity() {
        oldItemsFile();

    }

    public void itemData() {

    }

    public void oldItemsFile() {
        // IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_DDD_PPPPPP
        myFileReader.setFile(itemFile);
        stringList = myFileReader.getFileData();

        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).equals("END")) {
                break;
            }
            final String itemName = stringList.get(i).substring(0, 19);
            final String seller = stringList.get(i).substring(20, 35);
            final String buyer = stringList.get(i).substring(36, 50);
            final String days = stringList.get(i).substring(51, 54);
            final String bid = stringList.get(i).substring(55);
            // System.out.println("~"+itemName+"~"+seller+"~"+buyer+"~"+days+"~"+bid);
            final Item item = new Item(itemName, seller, buyer, days, bid);
            itemList.add(item);
            // System.out.println(itemList.get(i).getItemName());
        }
    }

    public ArrayList<Item> getItemsList(){
        return itemList;
    }

    public void bidItem(final String itemName, final String seller, final String buyer, final String bid) {

        for (int i = 0; i < itemList.size(); i++) {
            // System.out.println("Seller:_|" + itemList.get(i).userSeller.length() + "|_|"
            // + seller.length() +"|_");
            // System.out.println("Name:_|" + itemList.get(i).itemName + "|_|" + itemName
            // +"|_");
            // System.out.println("-----------------------------------------------------------");

            if (itemList.get(i).userSeller.equals(seller + " ") && itemList.get(i).itemName.equals(itemName)) {
                // System.out.println("hello");
                itemList.get(i).setItemBuyer(buyer);
                itemList.get(i).setItemBid(bid);
                final String listElement = itemList.get(i).currentItemsFileFormat();
                stringList.remove(i);
                stringList.remove(stringList.size() - 1); // remove end
                stringList.add(listElement);
                stringList.add("END");
                break;
            }
        }

        for (int i = 0; i < stringList.size(); i++) {
            // System.out.println(stringList.get(i));
        }
        // System.out.println("===============================");

    }

    public void newItem(final String itemName, final String seller, final String days, final String bid) {
        // item1 admin1 userBS 098 134.00
        // IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_DDD_PPPPPP
        // 03_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSS_DDD_PPPPPP
        final String buyer = "               "; // no buyer yet so blank
        // String buyer = "UUUUUUUUUUUUUUU";
        final Item newItem = new Item(itemName, seller, buyer, days, bid);
        final Item temp = itemList.get(itemList.size() - 1);// store end in temp

        itemList.remove(itemList.size() - 1); // remove END
        stringList.remove(stringList.size() - 1); // remove end
        itemList.add(newItem); // new user line
        final String listElement = itemList.get(itemList.size() - 1).currentItemsFileFormat();
        stringList.add(listElement);
        itemList.add(temp);
        stringList.add("END"); // add new END line at the end

        for (int i = 0; i < stringList.size(); i++) {

            // System.out.println(stringList.get(i));
            // System.out.println(stringList.get(i).length());
        }
        // System.out.println("===============================");

    }

    public void newItemsFile() {

        // System.out.println();
        File file = new File(location + "\\CSCI3060BackEnd\\BackEnd\\src\\Newitems.txt");
        //File file = new File("/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/test_write.txt");
        // Create the file
        MyFileWriter myFileWriter = new MyFileWriter();
        myFileWriter.setFile(file);
        try {
            myFileWriter.FileWriting(stringList);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }


}
