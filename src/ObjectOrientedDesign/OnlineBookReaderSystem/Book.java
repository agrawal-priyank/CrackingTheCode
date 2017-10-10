package ObjectOrientedDesign.OnlineBookReaderSystem;

public class Book {

    public int bookId;
    public String details;

    public Book(int bookId, String details){
        this.bookId = bookId;
        this.details = details;
    }

    public int getId(){
        return bookId;
    }

    public void setId(int id){
        bookId = id;
    }

    public String getDetails(){
        return details;
    }

    public void setDetails(String details){
        this.details = details;
    }

}