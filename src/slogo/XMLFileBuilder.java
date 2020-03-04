package slogo;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import slogo.XMLExceptions.XMLCreationExceptions;
import slogo.XMLExceptions.XMLTransformerException;

/**
 * This class serves to build an XMl document to contain the turtle environment passed
 */
public class XMLFileBuilder {

    public static final String SLOGO_TAG = "slogo";
    public static final String NUM_TURTLES_TAG = "numTurtles";
    public static final String BACKGROUND_COLOR_TAG = "background";

    private Turtle turtlesToSave;
    private DocumentBuilderFactory documentFactory;
    private DocumentBuilder documentBuilder;
    private Document document;
    private String background;

    private String filename;
    private int numTurtles;
    private final static String XML_ENDING = ".xml";
    private final static String DEFAULT_FOLDER = "data/";

    public XMLFileBuilder(Turtle turtle, String background, String filename) {
        this.turtlesToSave = turtle;
        this.background = background;
        //defaults to change later
        this.numTurtles = turtle.getTurtleNums();
        this.filename = filename + XML_ENDING;

        try{
            this.documentFactory = DocumentBuilderFactory.newInstance();
            this.documentBuilder = documentFactory.newDocumentBuilder();
            this.document = documentBuilder.newDocument();
        }
        catch (ParserConfigurationException pce) {
            throw new XMLCreationExceptions();
        }
    }

    /**
     * Builds the root element to add new element to and eventually transform
     */
    public void createDocument(){
        // root element
        Element root = document.createElement(SLOGO_TAG);
        document.appendChild(root);
        addElementsToRoot(root);
        transform();
    }

    /**
     * Transformer allows us to write the DOM object to the desired output StreamResult
     */
    private void transform(){
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(DEFAULT_FOLDER + filename));
            transformer.transform(domSource, streamResult);
        }
        catch (TransformerException tfe) {
            throw new XMLTransformerException();
        }
    }

    /**
     * Add the elements that are necessary to every turtle environment
     * @param root
     */
    private void addElementsToRoot(Element root)
    {
        //will need something that saves all the turtles
        //fillAllTurtles(); (for example)
        root.appendChild((document.createTextNode("\n")));
        Element numberOfTurtlesType = createElement(NUM_TURTLES_TAG, Integer.toString(numTurtles));
        root.appendChild(numberOfTurtlesType);
        root.appendChild((document.createTextNode("\n\n")));
        Element backgroundColorType = createElement(BACKGROUND_COLOR_TAG, background);
        root.appendChild(backgroundColorType);
        root.appendChild((document.createTextNode("\n\n")));


        for(int i = 0; i < numTurtles; i++) {
            //need to iterate through turtles to get all turtle elements in separate arrays
        }
        }


    /**
     * Creates a single element from a given tag name and text
     * @param tagName
     * @param text
     * @return
     */
    private Element createElement(String tagName, String text) {
        Element e = document.createElement(tagName);
        e.appendChild(document.createTextNode(text));

        return e;
    }

}

