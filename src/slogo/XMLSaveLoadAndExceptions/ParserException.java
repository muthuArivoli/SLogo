package slogo.XMLSaveLoadAndExceptions;
public class ParserException extends RuntimeException {

    public ParserException(String errorMessage) {
        super();
        System.out.println(errorMessage);
    }


}