import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserActivityTest {

    ArrayList<Item> itemsTestList = new ArrayList<Item>();
    ArrayList<String> stringTestList = new ArrayList<>();
    UserActivity testUserActivity = new UserActivity();

    @Before
    public void setupItemList() throws Exception {
        Item item1 = new Item("item1              ","admin1         ","userBS        ","098", "134.00" );
        Item item2 = new Item("item2              ","userSS         ","userFS        ","012", "012.34");
        Item item3 = new Item("item 3             ","userFS         ","admin1        ","034", "100.00");
        Item item4 = new Item("i t e m 4          ","userSS         ","userBS        ","011", "500.00");

        itemsTestList.add(item1);
        itemsTestList.add(item2);
        itemsTestList.add(item3);
        itemsTestList.add(item4);

        String line1 = "item1               admin1          userBS         098 134.00";
        String line2 = "item2               userSS          userFS         012 012.34";
        String line3 = "item 3              userFS          admin1         034 100.00";
        String line4 = "i t e m 4           userSS          userBS         011 500.00";
        String line5 = "END                                                          ";

        stringTestList.add(line1);
        stringTestList.add(line2);
        stringTestList.add(line3);
        stringTestList.add(line4);
        stringTestList.add(line5);

    }

    @Test
    public void oldItemsFile() {
        ArrayList<Item>gotList = testUserActivity.getItemsList();

        for(int i = 0; i < itemsTestList.size(); i++){
            //User user_1 = usersTestList[i];
            assertEquals(itemsTestList.get(i).getItemName(), gotList.get(i).getItemName());
            assertEquals(itemsTestList.get(i).getBuyerUserName(), gotList.get(i).getBuyerUserName());
            assertEquals(itemsTestList.get(i).getitemBid(), gotList.get(i).getitemBid());
            assertEquals(itemsTestList.get(i).getItemDays(), gotList.get(i).getItemDays());
            assertEquals(itemsTestList.get(i).getSellerUserName(), gotList.get(i).getSellerUserName());
            //assertEquals(itemsTestList.get(i).ge(), gotList.get(i).getUserCredit());
        }
    }

    @Test
    public void bidItem() {
        //making a bid on item 1
        testUserActivity.bidItem("item1              ","admin1        ","userFS        ","150.00");
        ArrayList<Item>gotList = testUserActivity.getItemsList();

        //set our test item1 to the correct new user and  bid
        itemsTestList.get(0).setItemBuyer("userFS        ");
        itemsTestList.get(0).setItemBid("150.00");


        assertEquals(itemsTestList.get(0).getItemName(), gotList.get(0).getItemName());
        //assertEquals(itemsTestList.get(0).getBuyerUserName(), gotList.get(0).getBuyerUserName());
        assertEquals(itemsTestList.get(0).getitemBid(), gotList.get(0).getitemBid());
        assertEquals(itemsTestList.get(0).getItemDays(), gotList.get(0).getItemDays());
        assertEquals(itemsTestList.get(0).getSellerUserName(), gotList.get(0).getSellerUserName());
    }

    @Test
    public void newItem() {
        Item newItem = new Item("itemX              ","userSS         ", "               ", "10", "090.00");
        //Item endItem = new Item("END                ","               ", "               ", "  ", "      ");
        itemsTestList.add(newItem);
        //itemsTestList.add(endItem);
        ArrayList<Item>gotList = testUserActivity.getItemsList();

        testUserActivity.newItem("itemX              ","userSS         ","10", "090.00");

        for(int i = 0; i < itemsTestList.size(); i++){
            //User user_1 = usersTestList[i];

            assertEquals(itemsTestList.get(i).getItemName(), gotList.get(i).getItemName());
            assertEquals(itemsTestList.get(i).getBuyerUserName(), gotList.get(i).getBuyerUserName());
            assertEquals(itemsTestList.get(i).getitemBid(), gotList.get(i).getitemBid());
            assertEquals(itemsTestList.get(i).getItemDays(), gotList.get(i).getItemDays());
            assertEquals(itemsTestList.get(i).getSellerUserName(), gotList.get(i).getSellerUserName());
            //assertEquals(itemsTestList.get(i).ge(), gotList.get(i).getUserCredit());

        }


    }

    @Test
    public void newItemsFile() throws IOException {
        testUserActivity.newItemsFile();

        MyFileReader testReader2 = new MyFileReader();
        String outFile = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/available items.txt";
        File userFile = new File(outFile);
        testReader2.setFile(userFile);
        ArrayList<String> gotList = testReader2.getFileData();
        for(int i = 0; i < stringTestList.size(); i++){
            //User user_1 = usersTestList[i];
            assertEquals(stringTestList.get(i), gotList.get(i));
            assertEquals(stringTestList.get(i), gotList.get(i));
            assertEquals(stringTestList.get(i), gotList.get(i));

        }

    }


}