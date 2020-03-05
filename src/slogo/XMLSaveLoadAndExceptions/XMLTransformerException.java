package slogo.XMLSaveLoadAndExceptions;

public class XMLTransformerException extends RuntimeException {
    public XMLTransformerException() {
        System.out.println("Could not create a Transformer instance");
    }
}
