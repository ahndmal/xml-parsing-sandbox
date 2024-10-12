package com.andmal.core;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XslConverter
{
    public String xmlToString(String xmlFile, String xslFile) throws Exception {
        InputStream xml = new FileInputStream(xmlFile);
        InputStream xsl = new FileInputStream(xslFile);

        StreamSource xmlSource = new StreamSource(xml);
        StreamSource stylesource = new StreamSource(xsl);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        StreamResult xmlOutput = new StreamResult(bos);

        Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
        transformer.transform(xmlSource, xmlOutput);

        return bos.toString();
    }

    public static void main(String[] arg) throws IOException {
        XslConverter c = new XslConverter();

        final String xml = "BookCatalog.xml";
        final String xsl = "BookCatalog.xsl";
        try {
            String result = c.xmlToString(xml, xsl);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}