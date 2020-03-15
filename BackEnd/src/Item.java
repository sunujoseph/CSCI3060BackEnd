/*              
*           ITEM CLASS
* This class reads in all the transactions through the user activity class.
* Then applies all of the daily transactions from a merged set of daily transaction files
* to these files to produce a new items file. Once the logout command has been entered, 
* we merge the new items file to the old items file. 
*/

public class Item{
    String itemName;
    String userBuyer;
    String userSeller;
    String itemBid;

    public Item(String name, String buyer, String seller, String bid){
        
    }

    public String getItemName(){
        return itemName;
    }

    public String getBuyerUserName(){
        return userBuyer;
    }

    public String getSellerUserName(){
        return userSeller;
    }

    public String getitemBid(){
        return itemBid;
    }

    public void setItemName(String item){
        itemName = item;
    }

    public void setItemBuyer(String buyer){
        userBuyer = buyer;
    }

    public void setItemSeller(String seller){
        userSeller = seller;
    }


}
