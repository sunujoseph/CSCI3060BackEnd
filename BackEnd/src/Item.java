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
    String itemDays;
    String itemBid;

    public Item(String name, String buyer, String seller, String days, String bid){
        itemName = name;
        userBuyer = buyer;
        userSeller = seller;
        itemDays = days;
        itemBid = bid;
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

    public String getItemDays(){
        return itemDays;
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

    public void setItemDays(String days){
        itemDays = days;
    }

    public void setItemSeller(String seller){
        userSeller = seller;
    }

    public String currentItemsFileFormat(){
        //item1               admin1          userBS         098 134.00
        //IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_DDD_PPPPPP
        // 62 characters
        String line = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 61; i++) {
            if(i==0){
                //System.out.println("hello" + itemName.length());
                line = itemName;
                i = i + itemName.length();
            }
            else if(i == 20){
                line = line + " " + userSeller;
                i = i + userSeller.length();
            }
            else if (i == 37){
                line = line + " "  + userBuyer;
                i = i + userBuyer.length();
            }
            else if (i == 52){
                line = line + "  "  + itemDays;  //somthing wrong the frontend's formatting. 
                i = i + itemDays.length();
            }
            else if (i == 56){
                line = line + " "  + itemBid;
                break;
            }

        }
        return line;
    }



}
