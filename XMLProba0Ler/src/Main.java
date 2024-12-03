import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        /**
         * Para leer un archivo XML Utilizamos el InputFactory
         */
        XMLInputFactory factory = XMLInputFactory.newInstance();

        XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("autores.xml"));

        /**
         * Para leer el archivo dado antes, camos utilizar un par de cositas
         */

        while (reader.hasNext()) { // Mientras haya algo que leer en el archivo XML entonces lo leemos
            int event = reader.next(); // Obtenemos el evento que se esta leyendo en el archivo XML

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("<" + reader.getLocalName() + ">");
                    if ("autor".equals(reader.getLocalName())) {
                        System.out.println("\tCodigo: " + reader.getAttributeValue(null, "codigo"));
                    }
                    break;
            }
        }
    }
    }