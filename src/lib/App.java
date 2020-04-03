package lib;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.io.FileWriter;

public class App {
    /**
     * function main creates 3 objects of class 'library' which are lib1, lib2, lib3
     * then it creates
     * @param oper and to this param we ascribe value by using method setVar
     * then we start loop do while which contains main menu of our app, here we are able to choose
     * one of object 'library' created earlier
     */
    public static void main(String[] args) {
        Library lib1 = new Library();
        Library lib2 = new Library();
        Library lib3 = new Library();

        String oper;
        do
        {
            System.out.println("Wszystkie biblioteki: 'lib1', 'lib2' lub 'lib3'");
            oper = setVar("bibliotekę");
            if("lib1".equalsIgnoreCase(oper)){
                menu(lib1);
            } else if("lib2".equalsIgnoreCase(oper)){
                menu(lib2);
            } else if("lib3".equalsIgnoreCase(oper)){
                menu(lib3);
            }
        }
        while(!"end".equalsIgnoreCase(oper));

    }

    /**
     *  method addBook uses method setVar to initialize all of variables in constructor of class 'book'
     *  and then create the object
     * @param library we initialize that earlier so we are adding object 'book' to right object of class 'library'
     * and next we induce function addBook from class 'library' to add created object to hashmap
     */
    public static void addBook(Library library) {
        String id = setVar("id");
        String bookName = setVar("nazwę książki");
        String author = setVar("autora");
        String publisher = setVar("wydawcę");
        String year = setVar("rok wydania");
        String quantityOfPages = setVar("ilość stron książki");
        Book book = new Book(Integer.valueOf(id), bookName, author, publisher, Integer.valueOf(year),
                Integer.valueOf(quantityOfPages));
        library.addBook(book);
    }

    /**
     * method removeBook extends method deleteBook from class 'library'
     * thanks to that user is able to relate to right object of class 'book' in
     * @param library that user is located
     * uses setVar to initialize 'id' of object 'book' that we want relate to
     */
    public static void removeBook(Library library){
        String id = setVar("id");
        library.deleteBook(Integer.valueOf(id));
    }

    /**
     * methos returnBooks extends returnBooks from class 'library' relate to
     * @param library which is initialized by user earlier
     */
    public static void returnBooks(Library library){
        library.returnBooks();
    }
    /**
     * returnAllBooks extends method returnAllBooks from class 'library', and relate to
     * @param library so program knows which object lib1, lib2 or lib3 we want to return then uses
     * @return and returns it as Collection
     */
    public static Collection<Book> returnAllBooks(Library library){
        return library.returnAllBooks();
    }

    /**
     * method editBook uses method setVar which user initialize 'id' of object 'book' in
     * @param library that he is located now to relate to object that he want to
     * edit parameters
     */
    public static void editBook(Library library){
        String id = setVar("Podaj id");
        String bookName = setVar("nazwę książki");
        String author = setVar("autora");
        String publisher = setVar("wydawcę");
        String year = setVar("rok wydania");
        String quantityOfPages = setVar("ilość stron książki");
        library.editBook(Integer.valueOf(id), new Book(Integer.valueOf(id),bookName, author, publisher,
                Integer.valueOf(year), Integer.valueOf(quantityOfPages)));
    }

    /**
     * method setVar takes variable value and prints
     * @param value ,thanks to that it can we used many times to initialize all values of variables
     * for instance in constructors of objects, then using
     * @return it returns variable val as string
     */
    public static String setVar(String value){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz " + value + ": ");
        String val = scanner.nextLine();
        System.out.println("Wpisales " + value + ": " + val);
        return val;
    }

    /**
     * method menu takes
     * @param lib which we initialized earlier
     * then prints method returnMenuLib() and checks what option user has chosen
     * and then run equal functions to that using loop do while
     */
    public static void menu(Library lib){
        returnMenuLib();
        String operation;
        do {
            operation = setVar("operację");
            if("addBook".equalsIgnoreCase(operation)){
                addBook(lib);
                returnMenuLib();
            } else if ("removeBook".equalsIgnoreCase(operation)){
                removeBook(lib);
                returnMenuLib();
            } else if ("returnAllBooks".equalsIgnoreCase(operation)){
                returnBooks(lib);
                returnMenuLib();
            } else if("editBook".equalsIgnoreCase(operation)){
                editBook(lib);
                returnMenuLib();
            } else if("libraryCopy".equalsIgnoreCase(operation)){
                libraryCopy(lib);
                returnMenuLib();
            }
        } while (!"end".equalsIgnoreCase(operation));
    }

    /**
     * method returnMenuLib is simple method that prints options of menu in being in object 'library'
     */
    public static void returnMenuLib() {
        System.out.println("Co chcesz zrobić?" + '\n' + "Dostępne metody to: addBook, removeBook, " +
                "returnAllBooks, editBook," + '\n' + "libraryCopy, end(powrót)");
    }

    /**
     * method libraryCopy takes
     * @param lib and creates file that name is initialized by user by method setVar()
     * and then saves all of objects 'book' and their values to that file
     */
    public static void libraryCopy(Library lib){
        String x = setVar(" nazwę pliku");
        try{
            File myObj = new File(x + ".txt");
            if (myObj.createNewFile()){
                System.out.println("Biblioteka " + myObj.getName() + " została zapisana");
            } else {
                System.out.println("Plik już istnieje");
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd");
            e.printStackTrace();
        }

        try{
            FileWriter myWriter = new FileWriter(x + ".txt");
            myWriter.write(" Wszystkie książki " + returnAllBooks(lib));
            myWriter.close();
            System.out.println("Zapisano");
        } catch (IOException e){
            System.out.println("Wystąpił błąd");
            e.printStackTrace();
        }
    }
}
