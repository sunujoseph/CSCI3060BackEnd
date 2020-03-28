import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user1  = new User("userBS         ", "BS", "123456.78");

    @Test
    public void getUserName() {
        String userName = "userBS         ";
        String gotName = user1.getUserName();
        assertEquals(userName, gotName);
    }

    @Test
    public void getUserCredit() {
        String credit = "123456.78";
        String gotCredit = user1.getUserCredit();
        assertEquals(credit, gotCredit);
    }

    @Test
    public void getUserCreditToFloat() {
        double credit = 123456.78;
        double gotCredit = user1.getUserCreditToFloat();
        assertEquals(gotCredit, credit, 0.1);
    }

    @Test
    public void getUserType() {
        String userType = "BS";
        String gotType  = user1.getUserType();
        assertEquals(userType, gotType);
    }

    @Test
    public void setUserName() {
        String userName = "userAS         ";
        user1.setUserName(userName);
        assertEquals(userName, user1.getUserName());
    }

    @Test
    public void setUserCredit() {
        String credit = "134567.88";
        user1.setUserCredit(credit);
        assertEquals(credit, user1.getUserCredit());
    }

    @Test
    public void setUserType() {
        String type = "SS";
        user1.setUserType(type);
        //System.out.println(user1.getUserType());
        assertEquals(type, user1.getUserType());
    }

    @Test
    public void currentUsersFileFormat() {
        String userCode = "userBS          BS 123456.78";
        String genCode  = user1.currentUsersFileFormat();
        assertEquals(userCode, genCode);
    }
}