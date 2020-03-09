
public class User{
    String userName;
    String userCredit;
    String userType;

    public User(String name, String type, String credit){
        
    }

    public String getUserName(){
        return userName;
    }

    public String getUserCredit(){
        return userCredit;
    }

    public double getUserCreditToDouble(){
        double creditDouble = Double.parseDouble(userCredit);
        return creditDouble;
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