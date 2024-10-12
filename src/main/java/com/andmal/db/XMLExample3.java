/*
package com.andmal.db;

import com.andmal.db.model.Author;
import com.andmal.db.model.Book;

import java.io.File;

public class XMLExample3 {

    public static String DB4O_FILE_NAME = "xml/book-3.xml";

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
*/
