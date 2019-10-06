package db;

import com.sun.org.apache.xml.internal.security.signature.ObjectContainer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileWriter;

public class ExportToXml {

    private static void exportToXml()  {

        XStream xstream = new XStream(new DomDriver());

        try  {

            FileWriter xmlFile = new FileWriter(XMLXML_FILE_NAME);

            ObjectContainer container = Db4o.openFile(DB4O_FILE_NAME);

            try  {

                ObjectSet result = container.query(Car.class);

                Car[] cars = new Car[result.size()];

                for (int i = 0; i < result.size(); i++)  {

                    Car car = (Car) result.next();
                    cars[i] = car;
                }

                String xml = xstream.toXML(cars);

                xmlFile.write("<?xml version=\"1.0\"?>\n" + xml);
                xmlFile.close();

            } finally  {
                container.close();
            }
        } catch (Exception ex)  {
            System.out.println(ex.getMessage());
        }
    }
}
