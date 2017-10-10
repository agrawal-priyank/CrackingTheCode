package ObjectOrientedDesign.OnlineBookReaderSystem;

import java.util.HashMap;

public class Library {

    private HashMap<Integer, Book> books;

    public Book addBook(int id, String details){
        if(books.containsKey(id)){
            return null;
        }
        Book book = new Book(id, details);
        books.put(id, book);
        return book;
    }

    public boolean removeBook(Book b){
        return remove(b.getId());
    }

    public boolean remove(int id){
        if(!books.containsKey(id)){
            return false;
        }
        books.remove(id);
        return true;
    }

}