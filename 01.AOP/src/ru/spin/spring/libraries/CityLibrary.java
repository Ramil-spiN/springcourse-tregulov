package ru.spin.spring.libraries;

import org.springframework.stereotype.Component;
import ru.spin.spring.Book;

@Component("cityLibraryBean")
public class CityLibrary extends AbstractLibrary {
    @Override
    public void getBook(String reader, Book book) {
        System.out.println(reader + " at the City Library gets the book - " + book.getName());
        System.out.println("------------------------------------");
    }

    public void returnBook() {
        System.out.println("Return book to the City Library");
        System.out.println("------------------------------------");
    }

    public String returnMagazine() {
        System.out.println("Return magazine to the City Library");
        System.out.println("------------------------------------");
        return "OK";
    }

    public void addBook() {
        System.out.println("Add book to the City Library");
        System.out.println("------------------------------------");
    }

    public void addMagazine() {
        System.out.println("Add magazine to the City Library");
        System.out.println("------------------------------------");
    }
}
