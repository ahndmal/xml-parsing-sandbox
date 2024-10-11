package com.andmal.db;

import com.sun.org.apache.xml.internal.security.signature.ObjectContainer;
import javaonline.xml.beastiehut.db.model.Book;

import java.io.File;

public class XMLExample3 {

    private static String DB4O_FILE_NAME = "book-3.xml";

    private static void setObjects()  {

        new File(DB4O_FILE_NAME).delete();

        ObjectContainer container = Db4o.openFile(DB4O_FILE_NAME);

        try  {

            Book book = new Book("BMW", new Author("Rubens Barrichello"));

            container.store(book);

            book = new Book("Ferrari", new Author("Michael Schumacher"));

            container.store(book);

        } finally  {

            container.close();
        }
    }
}
