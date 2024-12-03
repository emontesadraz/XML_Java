import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    XMLOutputFactory factory = XMLOutputFactory.newInstance();

    public void XMLWriter(){
        try {
            XMLStreamWriter write = factory.createXMLStreamWriter(new FileWriter("autores.xml"));

            write.writeStartDocument("1.0");
            write.writeStartElement("autores");
            write.writeStartElement("autor");
            write.writeAttribute("codigo","a1");
            write.writeStartElement("nome");
            write.writeCharacters("Alexandre Dumas");
            write.writeEndElement();
            write.writeStartElement("titulo");
            write.writeCharacters("El conde de montecristo");
            write.writeEndElement();
            write.writeCharacters("Los miserables");
            write.writeEndElement();
            write.writeStartElement("autor");
            write.writeAttribute("codigo","a2");
            write.writeCharacters("Fiodor Dostoyesvski");
            write.writeStartElement("titulo");
            write.writeCharacters("El idiota");
            write.writeEndElement();
            write.writeStartElement("titulo");
            write.writeCharacters("Noches Blancas");
            write.writeEndElement();
            write.writeEndElement();
            write.writeEndElement();
            write.writeEndDocument();
            write.flush();
            write.close();

        }catch (XMLStreamException | IOException e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }

}
