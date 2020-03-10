
/*
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
*/

import java.io.*;
import java.util.*;
public class Transactions{

    ArrayList<String> transactionsList = new ArrayList<String>();
    MyFileReader myFileReader = new MyFileReader();
    
    String trans_code;
    float available_credit;
    File DTF_file = new  File("DTF.txt");
    

    public Transactions(){

    }

    public void transactionsLoop(){
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
                create_trans();

            }
            else if(trans_code.equals("02")){
                //02-delete
                delete_trans();

            }
            else if(trans_code.equals("03")){
                //03-advertise
                adv_trans();

            }
            else if(trans_code.equals("04")){
                //04-bid
                bid_trans();

            }
            else if(trans_code.equals("05")){
                //05-refund
                refund_trans();

            }
            else if(trans_code.equals("06")){
                // 06-addcredit
                addcredit_trans();

            }


            //System.out.println(transactionsList.get(i)); 		
        }   

    }

    public void logout_trans(){
        //00-end of session

    }


    public void create_trans(){
        //01-create

    }


    public void delete_trans(){
        //02-delete

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
    public void adv_trans(){
        //03-advertise

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
    public void bid_trans(){
        //04-bid

    }


    /*
    *   Format: XX_UUUUUUUUUUUUUUU_SSSSSSSSSSSSSSS_CCCCCCCCC
    *   XX is a two-digit transaction code: 05-refund
    *   UUUUUUUUUUUUUUU is the buyer’s username
    *   SSSSSSSSSSSSSSS is the seller’s username
    *   CCCCCCCCC is the refund credit
    *   _ is a space
    */
    public void refund_trans(){
        //05-refund

    }


    public void addcredit_trans(){
        //06-addcredit

    }


    public void account_file(){

    }
    public void items_file(){

    }



}