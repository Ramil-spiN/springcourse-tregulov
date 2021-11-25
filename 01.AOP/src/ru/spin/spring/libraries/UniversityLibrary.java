package ru.spin.spring.libraries;

import org.springframework.stereotype.Component;
import ru.spin.spring.Book;

@Component("universityLibraryBean")
public class UniversityLibrary extends AbstractLibrary {
    @Override
    public void getBook(String reader, Book book) {
        System.out.println(reader + " at the University Library gets the book - " + book.getName());
        System.out.println("------------------------------------");
    }

    public void returnBook() {
        System.out.println("Return book to the University library");
        System.out.println("------------------------------------");
    }

    public void addBook() {
        System.out.println("Add book to the University library");
        System.out.println("------------------------------------");
    }
}
