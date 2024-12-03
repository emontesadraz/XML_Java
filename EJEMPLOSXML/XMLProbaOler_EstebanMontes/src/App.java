import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    XMLInputFactory factory = XMLInputFactory.newFactory();

    public void XMLReader(){
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("autores.xml"));
            while (reader.hasNext()){
                int casos = reader.next();
                switch (casos){
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("<" +reader.getLocalName()+">");
                        if ("autor".equals(reader.getLocalName())){
                            System.out.println("\tCodigo: "+reader.getAttributeValue(null,"codigo"));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("</"+reader.getLocalName()+">");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.println("\t"+reader.getText());
                        break;
                }
            }

        } catch (XMLStreamException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
