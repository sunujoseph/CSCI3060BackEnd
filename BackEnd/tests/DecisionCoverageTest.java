/*This test file does the decision coverage testing on the class User*/

import org.junit.Test;
import static org.junit.Assert.*;

public class DecisionCoverageTest {
    private User obj = new User("better admin    ", "AA", "987654.32");

    //condition for when i is equal to 0
    @Test
    public void zero(){
        obj.i = 0;
        String username = "better admin    ";
        String getUsername = obj.userName;
        assertEquals(username, getUsername);
    }

    //condition for when i is equal to 16
    @Test
    public void sixteen(){
        obj.i = 16;
        String usertype = "AA";
        String getusertype = obj.userType;
        assertEquals(usertype, getusertype);
    }

    //condition for when i is equal to 19
    @Test
    public void nineteen(){
        obj.i = 19;
        String credit = "987654.32";
        String getcredit = obj.userCredit;
        assertEquals(credit, getcredit);
    }

    //condition for when i is equal to neither conditions
    @Test
    public void none_conditions(){
        obj.i = 10;
        String getline = "";
        String gotline = obj.line;
        assertEquals(getline, gotline);
    }
}