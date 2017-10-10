package ObjectOrientedDesign.OnlineBookReaderSystem;

public class Display {

    private Book activeBook;
    private User activeUser;
    private int pageNumber;

    public void displayUser(User u){
        activeUser = u;
        refreshUserName();
    }

    public void displayBook(Book b){
        activeBook = b;
        pageNumber = 0;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void turnPageForward(){
        pageNumber++;
        refreshPage();
    }

    public void turnPageBackward(){
        pageNumber--;
        refreshPage();
    }

    public void refreshUserName(){ }
    public void refreshTitle(){ }
    public void refreshDetails(){ }
    public void refreshPage(){ }

}