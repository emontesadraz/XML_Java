import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            // Crear fábrica y lector de XML
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("products.xml"));

            // Variables temporales para almacenar los datos de un producto
            String id = null, name = null;
            double price = 0.0;
            int quantity = 0;

            // Leer el documento XML
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();

                        // Si es el inicio de un elemento <product>, leer el atributo "id"
                        if (elementName.equals("product")) {
                            id = reader.getAttributeValue(null, "id");
                        } else if (elementName.equals("name")) {
                            name = reader.getElementText();
                        } else if (elementName.equals("price")) {
                            price = Double.parseDouble(reader.getElementText());
                        } else if (elementName.equals("quantity")) {
                            quantity = Integer.parseInt(reader.getElementText());
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        // Cuando se cierra un <product>, crear el objeto Product
                        if (reader.getLocalName().equals("product")) {
                            products.add(new Product(id, name, price, quantity));
                        }
                        break;
                }
            }
            reader.close();

            // Imprimir los productos almacenados en el ArrayList
            for (Product product : products) {
                System.out.println(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}