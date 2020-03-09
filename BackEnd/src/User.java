
public class User{
    String userName;
    double userCredit;
    String userType;

    public User(String name, String type, String credit){
        
    }

    public String getUserName(){
        return userName;
    }

    public double getUserCredit(){
        return userCredit;
    }

    public String getUserCreditToString(){
        String s = String.valueOf(userCredit);
        return s;
    }

    public String getUserType(){
        return userType;
    }

    public void setUserName(String n){
        userName = n;
    }

    public void setUserCredit(double c){
        userCredit = c;
    }

    public void setUserType(String type){
        userName = type;
    }

}