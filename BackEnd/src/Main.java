
/* 
*   The Back End reads in the previous day’s User Accounts File and Available Items File
*   and then applies all of the daily transactions from a merged set of daily transaction files
*   to these files to produce a new Current User Accounts File and new Available Items
*   File for tomorrow’s Front End runs.
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) {



    //Call Transactions 
    Transactions transactions = new Transactions();
    transactions.transactionsLoop();

    


    }
}