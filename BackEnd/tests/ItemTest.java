import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item item1 = new Item("item1              ","admin1         ","userBS        ","098", "134.00" );

    @Test
    public void getItemName() {
        String item_name = "item1              ";
        String got_name = item1.getItemName();
        assertEquals(item_name, got_name);

    }

    @Test
    public void getBuyerUserName() {
        String seller_name = "admin1         ";
        String got_name = item1.getSellerUserName();
        assertEquals(seller_name, got_name);
    }

    @Test
    public void getSellerUserName() {
        String buyer_name = "userBS        ";
        String got_name = item1.getBuyerUserName();
        assertEquals(buyer_name, got_name);
    }

    @Test
    public void getItemDays() {
        String days_num = "098";
        String got_days = item1.getItemDays();
        assertEquals(days_num, got_days);
    }

    @Test
    public void getitemBid() {
        String bid_val = "134.00";
        String got_bid = item1.getitemBid();
        assertEquals(bid_val, got_bid);
    }

    @Test
    public void setItemName() {
        String newName = "itemX              ";
        item1.setItemName(newName);
        assertEquals(newName, item1.getItemName());
    }

    @Test
    public void setItemBuyer() {
        String newBuyer = "userXX        ";
        item1.setItemBuyer(newBuyer);
        assertEquals(newBuyer, item1.getBuyerUserName());
    }

    @Test
    public void setItemDays() {
        String itemDays = "022";
        item1.setItemDays(itemDays);
        assertEquals(itemDays, item1.getItemDays());
    }

    @Test
    public void setItemSeller() {
        String itemSeller = "admin1         ";
        item1.setItemSeller(itemSeller);
        assertEquals(itemSeller, item1.getSellerUserName());
    }

    @Test
    public void setItemBid() {
        String itemBid = "500.00";
        item1.setItemBid(itemBid);
        assertEquals(itemBid, item1.getitemBid());
    }

    @Test
    public void currentItemsFileFormat() {
        String testCode = "item1               admin1          userBS         098 134.00";
        String genCode = item1.currentItemsFileFormat();
        assertEquals(testCode, genCode);
    }
}