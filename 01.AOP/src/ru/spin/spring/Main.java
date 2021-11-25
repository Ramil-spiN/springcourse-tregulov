package ru.spin.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spin.spring.config.SpringConfig;
import ru.spin.spring.libraries.CityLibrary;
import ru.spin.spring.libraries.UniversityLibrary;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        CityLibrary cityLibrary = context.getBean("cityLibraryBean", CityLibrary.class);
        Book cityBook = context.getBean("bookBean", Book.class);
        cityBook.setName("Mysterious Island");
        cityLibrary.getBook("Mister Tom", cityBook);
        cityLibrary.returnBook();
        cityLibrary.returnMagazine();
        cityLibrary.addBook();
        cityLibrary.addMagazine();
        System.out.println("");

        UniversityLibrary universityLibrary = context.getBean("universityLibraryBean", UniversityLibrary.class);
        Book universityBook = context.getBean("bookBean", Book.class);
        universityBook.setName("Book of Arts");
        universityLibrary.getBook("Mister Gun", universityBook);
        universityLibrary.returnBook();
        universityLibrary.addBook();

        context.close();
    }
}
