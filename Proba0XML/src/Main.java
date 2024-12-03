import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("autores2.xml"));


        /**
         * Para empezar, tendremos que iniciar el documento.
         * Para hacerlo, tenemos que escribir lo siguiente: writeStartDocument()
         * Dentro de los paréntesis tendremos que poner "1.0"
         */
        writer.writeStartDocument("1.0");


        /**
         * Ahora determinaremos el elemento raíz
         * Lo haremos con este código: writeStartElement()
         * Dentro de los paréntesis pondremos el elemento raíz de nuestro XML
         */
        writer.writeStartElement("autores");


        /**
         * Ahora vamos a introducir lo que hay dentro de la etiqueta 'autores'
         * Primero pondremos otro StartElement, después, si hace falta, un atributo
         * y por último ponemos el caracter con writeCharacters
         */
        writer.writeStartElement("autor");
        writer.writeAttribute("codigo", "a1");
        writer.writeStartElement("nome");
        writer.writeCharacters("Alexandre Dumas");
        // Para cerrar las etiquetas hacemos lo siguiente:
        writer.writeEndElement(); // Esto cierra la etiqueta <nome>
        writer.writeStartElement("titulo");
        writer.writeCharacters("El Conde de Montecristo");
        writer.writeEndElement(); // Cierra la etiqueta <titulo> anterior
        writer.writeStartElement("titulo");
        writer.writeCharacters("Los Miserables");
        writer.writeEndElement(); // Cierra la etiqueta <titulo> anterior
        writer.writeEndElement(); // Cierra la etiqueta <autor> del principio

        writer.writeStartElement("autor");
        writer.writeAttribute("codigo", "a2");
        writer.writeStartElement("nome");
        writer.writeCharacters("Fiodor Dostoyevski");
        writer.writeEndElement(); // cierra etiqueta <nome>
        writer.writeStartElement("libro");
        writer.writeCharacters("El Idiota");
        writer.writeEndElement(); // cierra etiqueta <libro>
        writer.writeStartElement("libro");
        writer.writeCharacters("Noches Blancas");
        writer.writeEndElement(); // cierra etiqueta <libro>
        writer.writeEndElement(); //cierra etiqueta <autor>

        writer.writeEndElement(); // cierra etiqueta <autores>

        // Cerramos el escritor
        writer.close();

        System.out.println("Archivo creado con éxito");

    }
}