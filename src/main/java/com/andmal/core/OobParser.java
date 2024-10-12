package com.andmal.core;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OobParser {

    public static void parse() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("src/main/resources/xml/message.xml");
        Document doc = builder.parse(file);
        // Do something with the document here.
    }

    public static void writeXml() throws XMLStreamException, IOException {
        try (FileOutputStream fos = new FileOutputStream("test.xml")){
            XMLOutputFactory xmlOutFact = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = xmlOutFact.createXMLStreamWriter(fos);
            writer.writeStartDocument();
            writer.writeStartElement("test");
            // write stuff
            writer.writeEndElement();
        }
    }
}
