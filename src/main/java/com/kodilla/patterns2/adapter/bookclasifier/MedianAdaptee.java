package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {

    @Override
    public int medianaPublicationYear(Map<BookSignature, Book> books) {
        Statistics theStatistic = new Statistics();
        return theStatistic.medianaPublicationYear(books);
    }

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        Statistics theStatistic = new Statistics();
        return theStatistic.averagePublicationYear(books);
    }
}
