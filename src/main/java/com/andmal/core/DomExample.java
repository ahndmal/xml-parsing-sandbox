package com.andmal.core;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomExample {

    private static String XML_NAME = "xml/BookCatalogue.xml";

    public static void main(String[] args) {

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse(XML_NAME);

            Node root = document.getDocumentElement();

            System.out.println("List of books:");
            System.out.println();

            NodeList books = root.getChildNodes();

            for (int i = 0; i < books.getLength(); i++) {

                Node book = books.item(i);

                if (book.getNodeType() != Node.TEXT_NODE) {

                    NodeList bookProps = book.getChildNodes();

                    for(int j = 0; j < bookProps.getLength(); j++) {

                        Node bookProp = bookProps.item(j);

                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    System.out.println("===========>>>>");
                }
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
