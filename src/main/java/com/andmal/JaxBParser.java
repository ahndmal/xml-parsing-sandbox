package com.andmal;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class RootElementClass {

}

public class JaxBParser {

    public static void parse() throws JAXBException, IOException {
        try (FileInputStream adrFile = new FileInputStream("test")) {
            JAXBContext ctx = JAXBContext.newInstance(RootElementClass.class);
            Unmarshaller um = ctx.createUnmarshaller();
            RootElementClass rootElement = (RootElementClass) um.unmarshal(adrFile);
        }
    }

    public static void parse(RootElementClass out) throws IOException, JAXBException {
        try (FileOutputStream adrFile = new FileOutputStream("test.xml")) {
            JAXBContext ctx = JAXBContext.newInstance(RootElementClass.class);
            Marshaller ma = ctx.createMarshaller();
            ma.marshal(out, adrFile);
        }
    }

}
