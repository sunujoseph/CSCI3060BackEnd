import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountsTest {

    ArrayList<User> usersTestList = new ArrayList<User>();
    ArrayList<String> stringTestList = new ArrayList<String>();
    Accounts testAccounts = new Accounts();

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

        stringTestList.add(line1);
        stringTestList.add(line2);
        stringTestList.add(line3);
        stringTestList.add(line4);
        stringTestList.add(line5);
        stringTestList.add(line6);
        stringTestList.add(line7);

    }

    @Test
    public void loginInfo() {
    }

    @Test
    public void oldUserFile() throws Exception {
        //setupUserList();

        ArrayList<User>gotList = testAccounts.getUsersList();
        for(int i = 0; i < usersTestList.size(); i++){
            //User user_1 = usersTestList[i];
            assertEquals(usersTestList.get(i).getUserName(), gotList.get(i).getUserName());
            assertEquals(usersTestList.get(i).getUserType(), gotList.get(i).getUserType());
            assertEquals(usersTestList.get(i).getUserCredit(), gotList.get(i).getUserCredit());

        }


    }

    @Test
    public void refund() {
        testAccounts.refund("userBS         ","userFS         ", "50" );
        ArrayList<User>gotList = testAccounts.getUsersList();

        //Seller loses 50 bucks, buyer gets 50 bucks
        usersTestList.get(0).setUserCredit("123406.78");
        usersTestList.get(2).setUserCredit("111161.11");

        //Buyer
        assertEquals(usersTestList.get(0).getUserCredit(), gotList.get(0).getUserCredit());
        //Seller
        assertEquals(usersTestList.get(2).getUserCredit(), gotList.get(2).getUserCredit());
    }

    @Test
    public void addCurrentUserCredit() {
        usersTestList.get(1).setUserCredit("000050.00"); //check if resetting or adding to value
        testAccounts.addCurrentUserCredit("admin1         ", "AA", "000050.00");
        ArrayList<User>gotList = testAccounts.getUsersList();
        assertEquals(usersTestList.get(1).getUserCredit(), gotList.get(1).getUserCredit());
    }

    @Test
    public void newUser() {
        User newUser = new User("userXX         ", "BS", "000500.00");
        usersTestList.add(newUser);
        testAccounts.newUser("userXX         ", "BS", "000500.00");
        ArrayList<User>gotList = testAccounts.getUsersList();

        for(int i = 0; i < usersTestList.size(); i++){
            //User user_1 = usersTestList[i];
            assertEquals(usersTestList.get(i).getUserName(), gotList.get(i).getUserName());
            assertEquals(usersTestList.get(i).getUserType(), gotList.get(i).getUserType());
            assertEquals(usersTestList.get(i).getUserCredit(), gotList.get(i).getUserCredit());

        }


    }

    @Test
    public void deleteUserFile() {
        //delete first user
        usersTestList.remove(0);
        testAccounts.deleteUserFile("userBS         ","BS","123456.78");
        ArrayList<User>gotList = testAccounts.getUsersList();

        assertEquals(usersTestList.get(0).getUserName(), gotList.get(0).getUserName());

    }

    @Test
    public void newUserFile() {
        testAccounts.newUserFile();

        MyFileReader testReader2 = new MyFileReader();
        String outFile = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/test_write.txt";
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