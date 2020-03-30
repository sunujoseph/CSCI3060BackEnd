/*This test file does the decision coverage testing on the class Transactions*/
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class LoopCoverageTest {
    private Transactions transactions = new Transactions();

    //makes 0 passes to the loop
    @Test
    public void transactionsLoop_zero() {
        int i = 0;
        String trans_code = "03 Lenovo Tab M10      userSS          030 900.90";
        String got_transcode = transactions.trans_code;
        assertEquals(trans_code, got_transcode);
    }

    //makes 1 passes to the loop
    @Test
    public void transactionsLoop_one() {
        int i = 1;
        String trans_code = "05 userFS          userSS          012012.34";
        String got_transcode = transactions.trans_code;
        assertEquals(trans_code, got_transcode);
    }

    //makes 2 passes to the loop
    @Test
    public void transactionsLoop_two() {
        int i = 2;
        String trans_code = "00 userSS          SS 222222.22";
        String got_transcode = transactions.trans_code;
        assertEquals(trans_code, got_transcode);
    }

    //makes more passes to the loop
    @Test
    public void transactionsLoop_many() {
        int i = 14;
        //String trans_code = null;
        String got_transcode = transactions.trans_code;
        assertEquals(null, got_transcode);
    }
}