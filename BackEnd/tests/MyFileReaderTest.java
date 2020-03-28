import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyFileReaderTest {

    ArrayList<String> stringTestList = new ArrayList<String>();
    MyFileReader testReader = new MyFileReader();

    @Before
    public void setupStringList() throws Exception {
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


        String file = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/current_user_accounts.txt";
        File userFile = new File(file);
        testReader.setFile(userFile);

    }

    @Test
    public void getFile() {
        String file2 = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/current_user_accounts.txt";
        File userFiletest = new File(file2);
        assertEquals(userFiletest, testReader.getFile());


    }

    @Test
    public void setFile() {
        MyFileReader testReader = new MyFileReader();
        String file = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/DTF.txt";
        File userFile = new File(file);
        testReader.setFile(userFile);
        assertEquals(userFile, testReader.getFile());
    }

    @Test
    public void getFileData() {
        ArrayList<String> gotList = testReader.getFileData();
        for(int i = 0; i < stringTestList.size(); i++){
            //User user_1 = usersTestList[i];
            assertEquals(stringTestList.get(i), gotList.get(i));
            assertEquals(stringTestList.get(i), gotList.get(i));
            assertEquals(stringTestList.get(i), gotList.get(i));

        }

    }
}