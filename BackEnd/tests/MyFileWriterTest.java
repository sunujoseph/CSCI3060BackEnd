import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyFileWriterTest {
    ArrayList<String> stringTestList = new ArrayList<String>();
    MyFileWriter testReader = new MyFileWriter();

    String userAccountsFile = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/current_user_accounts.txt";
    File userFile = new File (userAccountsFile);

    String dtfFile = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/DTF.txt";
    File dailytransFile = new File (dtfFile);

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
        testReader.setFile(dailytransFile);
        assertEquals(dailytransFile, testReader.getFile());
    }

    @Test
    public void fileWriting() {
        String newfile = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/test_write.txt";
        File outfile = new File(newfile);
        testReader.setFile(outfile);
        try {
            testReader.FileWriting(stringTestList);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        MyFileReader testReader2 = new MyFileReader();

        File userFile = new File(newfile);
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