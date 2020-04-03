package lib;

import java.util.Collection;
import java.util.HashMap;

/**
 * creating class library
 * then creating hashmap in which all objects 'book' will be saved
 */
public class Library {

    private HashMap<Integer, Book> books = new HashMap<>();

    /**
     * method addBook add created in class 'App' object
     * 'book' to hashmap and indentify them by 'id'
     */
    public void addBook(Book book){
        books.put(book.getId(), book);
    }

    /**
     * method deleteBook erases object 'book' from hashmap
     * which is next cleaned up by garbage collector
     * @param integer initialize value of 'id' of object book that we want relate to
     */
    public void deleteBook(Integer integer){
        books.remove(integer);
    }

    /**
     * method editBook which is editing parameters of object 'book'
     * @param integer initialize 'id' of object that we want relate to
     */
    public void editBook(Integer integer, Book book){
        books.replace(integer, book);
    }

    /**
     * method returnBooks prints all object 'book' and their values
     */
   public void returnBooks(){
        System.out.println("Wszystkie ksiazki: ");
        for (Book book : books.values()) {
            System.out.println(book);
        }
   }

    /**
     *  method returnAllBooks uses
     * @return and returns as Collection all objects 'book' and their values
     */
    public Collection<Book> returnAllBooks(){
        return books.values();
    }
}
