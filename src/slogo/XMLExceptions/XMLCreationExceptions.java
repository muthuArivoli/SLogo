package slogo.XMLExceptions;

public class XMLCreationExceptions extends RuntimeException{

    public XMLCreationExceptions() {
        System.out.println("Could not create a XML document instance");
    }
}
