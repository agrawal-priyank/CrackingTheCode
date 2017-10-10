package ObjectOrientedDesign.OnlineBookReaderSystem;

public class User {

    private int userId;
    private String details;
    private int accountType;

    public User(int userId, String details, int accountType){
        this.userId = userId;
        this.details = details;
        this.accountType = accountType;
    }

    public int getId(){
        return userId;
    }

    public void setId(int id){
        userId = id;
    }

    public String getDetails(){
        return details;
    }

    public void setDetails(String details){
        this.details = details;
    }

    public int getAccountType(){
        return accountType;
    }

    public void setAccountType(int t){
        this.accountType = t;
    }

}