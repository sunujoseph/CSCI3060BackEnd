
/*
*           TRANSACTION CLASS
*   Here is where the BackEnd handles reading each DTF file
*   Rules of DTF file:
*
*   At the end of each session, when the logout transaction is processed, a daily
*   transaction file for the day is written, listing every transaction made in the session.
*   
*   Format:
*   XX_UUUUUUUUUUUUUUU_TT_CCCCCCCCC
*   XX is a two-digit transaction code: 01-create, 02-delete, 06-addcredit, 00-end of session
*   UUUUUUUUUUUUUUU is the username
*   TT is the user type (AA=admin, FS=full-standard, BS=buy-standard, SS=sell-standard)
*   CCCCCCCCC is the available credit
*   _ is a space
*
*   ====================================================================================================
*   
*   Interacts with FileReader.java
*   Interacts with Accounts.java for user accounts data writing/reading
*   Interacts with UserActivity.java for list of available item data writing/reading
*   
*   Reads through the DTF file transactions
*   Depending on the transaction, we create updated available items.txt and current_user_accounts.txt
*   by calling Accounts.java and UserActivity.java
*/

import java.io.*;
import java.util.*;
public class Transactions{

    ArrayList<String> transactionsList = new ArrayList<String>();
    MyFileReader myFileReader = new MyFileReader();
    
    public int i;
    String trans_code;
    float available_credit;
    String location = System.getProperty("user.dir");
    //String file = location + "\\CSCI3060BackEnd\\BackEnd\\src\\DTF.txt";
    String file;
    //String file = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/DTF.txt";
    File DTF_file;

    Accounts accounts = new Accounts();
    UserActivity userActivity = new UserActivity();
    
    public Transactions(){
        //file = "/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd/BackEnd/src/DTF.txt";
        file = location + "\\CSCI3060BackEnd\\BackEnd\\src\\DTF.txt";
        DTF_file = new File(file);
    }

    public Transactions(String path){
        this.file = path;
        this.DTF_file = new File(this.file);
    }

    public void transactionsLoop() throws IOException {
        //set file to read DTF file
        //store list of strings in a ArrayList
        myFileReader.setFile(DTF_file);
        transactionsList = myFileReader.getFileData();

        //Loop for iterating ArrayList
        for (int i = 0; i < transactionsList.size(); i++) { 
            
            //get the code of XX in the DTF file
            //gets the substring of the first 2 characters
            trans_code = transactionsList.get(i).substring(0, 2);


            if(trans_code.equals("00")){
                //00-end of session
                logout_trans();
            }
            else if(trans_code.equals("01")){
                //01-create
                //gets substring of username
                String name = transactionsList.get(i).substring(3, 18);
                String type = transactionsList.get(i).substring(19,21);
                String credit = transactionsList.get(i).substring(22);
                create_trans(name,type,credit);

            }
            else if(trans_code.equals("02")){
                //02-delete
                String name = transactionsList.get(i).substring(3, 18);
                String type = transactionsList.get(i).substring(19,21);
                String credit = transactionsList.get(i).substring(22);
                delete_trans(name, type, credit);

            }
            else if(trans_code.equals("03")){
                //03-advertise
                //XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSS_DDD_PPPPPP
                //XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_DDD_PPPPPP
                //03 Lenovo Tab M10      userSS          030 000190
                //username are 15 char long
                //items are supposed be 25 chars long
                //03 Lenovo Tab M10      userSS        030 000190
                String itemName = transactionsList.get(i).substring(3, 22); //25 chars long
                String sellerName = transactionsList.get(i).substring(23,37); //15 chars long
                String days = transactionsList.get(i).substring(39,42);
                String bid = transactionsList.get(i).substring(43);
                //System.out.println(itemName.length());
                //System.out.println(sellerName.length());
                //System.out.println(""+itemName+"_"+sellerName+"_"+days+"_"+bid);
                //System.out.println(itemName.length());
                adv_trans(itemName, sellerName, days, bid);

            }
            else if(trans_code.equals("04")){
                //04-bid
                //XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_DDD_PPPPPP
                //XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_PPPPPP
                //04 i t e m 4           userSS          better admin   500.01
                String itemName = transactionsList.get(i).substring(3, 22); //25 chars long
                String sellerName = transactionsList.get(i).substring(23,37); //15 chars long
                String buyerName = transactionsList.get(i).substring(39,53); //15 chars long
                String bid = transactionsList.get(i).substring(54);
                //System.out.println(itemName.length());
                //System.out.println(sellerName.length());
                //System.out.println(buyerName.length());
                //System.out.println(""+itemName+"_"+sellerName+"_"+buyerName+"_"+bid);

                bid_trans(itemName, sellerName, buyerName, bid);

            }
            else if(trans_code.equals("05")){
                //05-refund
                //05 userFS          userSS          012012.34
                //XX_UUUUUUUUUUUUUUU_SSSSSSSSSSSSSSS_CCCCCCCCC
                String buyerName = transactionsList.get(i).substring(3, 18); //25 chars long
                String sellerName = transactionsList.get(i).substring(19,34); //15 chars long
                String bid = transactionsList.get(i).substring(35);

                //System.out.println(sellerName+"_"+buyerName+"_"+bid);
                //System.out.println(sellerName.length());
                //System.out.println(buyerName.length());
                //System.out.println(bid.length());

                refund_trans(sellerName, buyerName, bid);

            }
            else if(trans_code.equals("06")){
                // 06-addcredit
                String name = transactionsList.get(i).substring(3, 18);
                String type = transactionsList.get(i).substring(19,21);
                String credit = transactionsList.get(i).substring(22);
                addcredit_trans(name, type, credit);

            }


            //System.out.println(transactionsList.get(i)); 		
        }   

        account_file(); //create new users file
        items_file();   //create new items file

    }

    public void logout_trans(){
        //00-end of session

    }


    public void create_trans(String name, String type, String credit){
        //01-create
        accounts.newUser(name, type, credit);
    }


    public void delete_trans(String name, String type, String credit){
        //02-delete
        accounts.deleteUserFile(name, type, credit);

    }


    /*
    *   Format: XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSS_DDD_PPPPPP
    *   XX is a two-digit transaction code: 03-advertise.
    *   IIIIIIIIIIIIIIIIIII is the item name
    *   SSSSSSSSSSSSSS is the seller’s username
    *   DDD Is the number of days to auction
    *   PPPPPP is the minimum bid
    *   _ is a space
    */
    public void adv_trans(String itemName, String sellerName, String days, String bid){
        //03-advertise
        userActivity.newItem(itemName, sellerName, days, bid);

    }


    /* 
    *   Format: XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_PPPPPP
    *   XX is a two-digit transaction code: 04-bid.
    *   IIIIIIIIIIIIIIIIIII is the item name
    *   SSSSSSSSSSSSSSS is the seller’s username
    *   UUUUUUUUUUUUUUU is the buyer's username
    *   PPPPPP is the new bid
    *   _ is a space
    */
    public void bid_trans(String itemName, String sellerName, String buyerName, String bid){
        //04-bid
        //04 i t e m 4           userSS          better admin   500.01
        //i t e m 4           userSS          userBS         011 500.00
        userActivity.bidItem(itemName, sellerName, buyerName, bid);

    }


    /*
    *   Format: XX_UUUUUUUUUUUUUUU_SSSSSSSSSSSSSSS_CCCCCCCCC
    *   XX is a two-digit transaction code: 05-refund
    *   UUUUUUUUUUUUUUU is the buyer’s username
    *   SSSSSSSSSSSSSSS is the seller’s username
    *   CCCCCCCCC is the refund credit
    *   _ is a space
    */
    public void refund_trans(String sellerName, String buyerName, String bid){
        //05-refund
        //XX_UUUUUUUUUUUUUUU_SSSSSSSSSSSSSSS_CCCCCCCCC
        accounts.refund(sellerName, buyerName, bid);

    }


    public void addcredit_trans(String name, String type, String credit){
        //06-addcredit
        accounts.addCurrentUserCredit(name, type, credit);

    }


    public void account_file() throws IOException {
        accounts.newUserFile();
    }
    public void items_file() throws IOException {
        userActivity.newItemsFile();    
    }



}
