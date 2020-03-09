
public class Item{
    String itemName;
    String userBuyer;
    String userSeller;
    double itemBid;

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

    public double getitemBid(){
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