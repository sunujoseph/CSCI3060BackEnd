/* 
*           USER CLASS
* This class takes in all information regarding its user. 
* It makes sure if the new user follows its constraints, such as its file.
* Used to store and format user accounts data.
*/

public class User{
    String userName;
    String userCredit;
    String userType;
    

    public User(String name, String type, String credit){
        userName = name;
        userCredit = credit;
        userType = type;
    }

    public String getUserName(){
        return userName;
    }

    public String getUserCredit(){
        return userCredit;
    }

    public double getUserCreditToFloat(){
        double creditFloat = Float.parseFloat(userCredit);
        return creditFloat;
    }

    public String getUserType(){
        return userType;
    }

    public void setUserName(String n){
        userName = n;
    }

    public void setUserCredit(String c){
        userCredit = c;
    }

    public void setUserType(String type){
        userName = type;
    }

    public String currentUsersFileFormat(){
        //better admin    AA 987654.32
        //length is 28 characters 
        String line = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 28; i++) {
            if(i==0){
                line = userName;
                i = i + userName.length();

            }
            else if(i == 16){
                line = line + " " + userType;
                i = i + userType.length();

            }
            else if (i == 19){
                line = line + " "  + userCredit;
                break;
            }
        }
        return line;
    }

}
