import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TransactionsTest {
    ArrayList<Item> itemsTestList = new ArrayList<Item>();
    ArrayList<String> stringItemTestList = new ArrayList<>();

    ArrayList<User> usersTestList = new ArrayList<User>();
    ArrayList<String> stringUsersTestList = new ArrayList<>();

    String path = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/DTF.txt";
    Transactions transactions = new Transactions(path);

    @Before
    public void setupTransactions() throws Exception {
        String transaction0 = "00 admin1          AA 000150.78";
        String transaction1 = "01 newuser         FS 002000.23";
        String transaction2 = "02 userFS          AA 111111.11";
        String transaction3 = "03 Lenovo Tab M10      userSS          030 900.90";
        String transaction4 = "04 i t e m 4           userSS          better admin   500.01";
        String transaction5 = "05 userFS          userSS          012012.34";
        String transaction6 = "06 userBS          AA 200556.78";

    }

    @Before
    public void setupUserList() throws Exception {
        User user1  = new User("userBS         ", "BS", "123456.78");
        User user2  = new User("admin1         ", "AA", "000150.78");
        User user3  = new User("userFS         ", "FS", "111111.11");
        User user4  = new User("userSS         ", "SS", "222222.22");
        User user5  = new User("userMaxCredit  ", "FS", "999999.00");
        User user6  = new User("better admin   ", "AA", "987654.32");

        usersTestList.add(user1);
        usersTestList.add(user2);
        usersTestList.add(user3);
        usersTestList.add(user4);
        usersTestList.add(user5);
        usersTestList.add(user6);

        String line1 = "userBS          BS 123456.78";
        String line2 = "admin1          AA 000150.78";
        String line3 = "userFS          FS 111111.11";
        String line4 = "userSS          SS 222222.22";
        String line5 = "userMaxCredit   FS 999999.00";
        String line6 = "better admin    AA 987654.32";
        String line7 = "END                         ";

        stringUsersTestList.add(line1);
        stringUsersTestList.add(line2);
        stringUsersTestList.add(line3);
        stringUsersTestList.add(line4);
        stringUsersTestList.add(line5);
        stringUsersTestList.add(line6);
        stringUsersTestList.add(line7);

    }

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

        stringItemTestList.add(line1);
        stringItemTestList.add(line2);
        stringItemTestList.add(line3);
        stringItemTestList.add(line4);
        stringItemTestList.add(line5);

    }

    @Test
    public void transactionsLoop() throws IOException {
        //loops through functions below which already have tests
        //uses transaction codes read from file, our test daily transaction file has one code for each function
        //simply test statement coverage of dtf file (does everything run)

        transactions.transactionsLoop(); //add bools at the end of each line and assert them?
    }

    @Test
    public void logout_trans() {
        transactions.logout_trans();
    }

    @Test
    public void create_trans() {
        User newUser = new User("userXX         ", "BS", "000500.00");
        usersTestList.add(newUser);
        transactions.create_trans("userXX         ", "BS", "000500.00");
        ArrayList<User>gotList = transactions.accounts.getUsersList();

        for(int i = 0; i < usersTestList.size(); i++){
            //User user_1 = usersTestList[i];
            assertEquals(usersTestList.get(i).getUserName(), gotList.get(i).getUserName());
            assertEquals(usersTestList.get(i).getUserType(), gotList.get(i).getUserType());
            assertEquals(usersTestList.get(i).getUserCredit(), gotList.get(i).getUserCredit());

        }
    }

    @Test
    public void delete_trans() {
        usersTestList.remove(0);
        transactions.delete_trans("userBS         ","BS","123456.78");
        ArrayList<User>gotList = transactions.accounts.getUsersList();

        assertEquals(usersTestList.get(0).getUserName(), gotList.get(0).getUserName());
    }

    @Test
    public void adv_trans() {
        Item newItem = new Item("itemX              ","userSS         ", "               ", "10", "090.00");
        //Item endItem = new Item("END                ","               ", "               ", "  ", "      ");
        itemsTestList.add(newItem);
        //itemsTestList.add(endItem);
        ArrayList<Item>gotList = transactions.userActivity.getItemsList();

        transactions.adv_trans("itemX              ","userSS         ","10", "090.00");

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
    public void bid_trans() {
        transactions.userActivity.bidItem("item1              ","admin1        ","userFS        ","150.00");
        ArrayList<Item>gotList = transactions.userActivity.getItemsList();

        //set our test item1 to the correct new user and  bid
        itemsTestList.get(0).setItemBuyer("userFS        ");
        itemsTestList.get(0).setItemBid("150.00");


        assertEquals(itemsTestList.get(0).getItemName(), gotList.get(0).getItemName());
        assertEquals(itemsTestList.get(0).getBuyerUserName(), gotList.get(0).getBuyerUserName());
        assertEquals(itemsTestList.get(0).getitemBid(), gotList.get(0).getitemBid());
        assertEquals(itemsTestList.get(0).getItemDays(), gotList.get(0).getItemDays());
        assertEquals(itemsTestList.get(0).getSellerUserName(), gotList.get(0).getSellerUserName());
    }

    @Test
    public void refund_trans() {
        transactions.accounts.refund("userBS         ","userFS         ", "50" );
        ArrayList<User>gotList = transactions.accounts.getUsersList();

        //Seller loses 50 bucks, buyer gets 50 bucks
        usersTestList.get(0).setUserCredit("123406.78");
        usersTestList.get(2).setUserCredit("111161.11");

        //Buyer
        assertEquals(usersTestList.get(0).getUserCredit(), gotList.get(0).getUserCredit());
        //Seller
        assertEquals(usersTestList.get(2).getUserCredit(), gotList.get(2).getUserCredit());
    }

    @Test
    public void addcredit_trans() {
        usersTestList.get(1).setUserCredit("000050.00"); //check if resetting or adding to value
        transactions.accounts.addCurrentUserCredit("admin1         ", "AA", "000050.00");
        ArrayList<User>gotList = transactions.accounts.getUsersList();
        assertEquals(usersTestList.get(1).getUserCredit(), gotList.get(1).getUserCredit());
    }

    @Test
    public void account_file() throws IOException {
        transactions.accounts.newUserFile();

        MyFileReader testReader2 = new MyFileReader();
        String outFile = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/test_write.txt";
        File userFile = new File(outFile);
        testReader2.setFile(userFile);
        ArrayList<String> gotList = testReader2.getFileData();
        for(int i = 0; i < stringUsersTestList.size(); i++){
            //User user_1 = usersTestList[i];
            assertEquals(stringUsersTestList.get(i), gotList.get(i));
            assertEquals(stringUsersTestList.get(i), gotList.get(i));
            assertEquals(stringUsersTestList.get(i), gotList.get(i));

        }
    }

    @Test
    public void items_file() throws IOException {
        transactions.userActivity.newItemsFile();

        MyFileReader testReader2 = new MyFileReader();
        String outFile = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/test_write.txt";
        File userFile = new File(outFile);
        testReader2.setFile(userFile);
        ArrayList<String> gotList = testReader2.getFileData();
        for(int i = 0; i < stringItemTestList.size(); i++){
            //User user_1 = usersTestList[i];
            assertEquals(stringItemTestList.get(i), gotList.get(i));
            assertEquals(stringItemTestList.get(i), gotList.get(i));
            assertEquals(stringItemTestList.get(i), gotList.get(i));

        }
    }
}