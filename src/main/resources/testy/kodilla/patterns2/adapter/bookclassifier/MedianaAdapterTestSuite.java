package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianaAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianaAdapterTestSuite {

    @Test
    public void testTotalSalary() {
        Book book1 = new Book("Kasprzycki", "Korzenie miasta", 2010, "a1");
        Book book2 = new Book("Rivers", "Rut", 1996, "a2");
        Book book3 = new Book("Wieliczka", "Zolnierze wykleci", 1998, "a3");
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        MedianaAdapter medianaAdapter = new MedianaAdapter();
        int calculateMediana = medianaAdapter.publicationYearMedian(books);
        assertEquals(1998, calculateMediana);
    }
}
