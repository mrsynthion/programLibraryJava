package lib;

/**
 * creating class 'book' and initialize all of its variables
 * @param id - 'book' id
 * @param bookName - 'book' title
 * @param author - 'book' author
 * @param publisher - 'book' publisher
 * @param year - year of publishing 'book'
 * @param quantityOfPages - number of pages 'book' has
 * then creating constructor and getters
 */
public class Book {
    private int id;
    private String bookName;
    private String author;
    private String publisher;
    private int year;
    private int quantityOfPages;


    public Book (int id, String bookName, String author, String publisher, int year, int quantityOfPages) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.quantityOfPages = quantityOfPages;
    }

    public int getId(){
        return id;
    }

    public String getBookName(){
        return bookName;
    }

    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getQuantityOfPages() {
        return quantityOfPages;
    }
/**
* using method toString() to convert 'book' object to string that we are able
* to print it
**/
    @Override
    public String toString() {
        return "Book{" +
                "Id = " + id +
                ", nazwa książki = '" + bookName +  '\'' + "\n" +
                ", autor = '" + author  + '\'' +
                ", wydawca = '" + publisher + '\'' + "\n" +
                ", rok =" + year +
                ", ilość stron = " + quantityOfPages +
                '}';
    }
}

