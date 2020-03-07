package slogo.XMLSaveLoadAndExceptions;

import java.io.File;
import javafx.scene.paint.Color;
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
import slogo.FrontEndAPI;
import slogo.Visualizer.Visualizer;

/**
 * This class serves to build an XMl document to contain the turtle environment passed
 */
public class XMLFileBuilder {

    public static final String SLOGO_TAG = "slogo";
    public static final String NUM_TURTLES_TAG = "numTurtles";
    public static final String BACKGROUND_COLOR_TAG = "background";
    public static final String PEN_COLOR_TAG = "penColor";
    public static final String PALETTE_TAG = "palette";
    public static final String CURRENT_SCRIPTS_TAG = "currentScripts";


    private DocumentBuilderFactory documentFactory;
    private DocumentBuilder documentBuilder;
    private Document document;
    private String background;
    private String filename;
    private Color penColor;
    private String currentScripts;

    private int numTurtles;
    private final static String XML_ENDING = ".xml";
    private final static String DEFAULT_FOLDER = "data/";

    public XMLFileBuilder(FrontEndAPI fAPI, Visualizer vis, String filename) {
        this.numTurtles = fAPI.turtles();
        this.background = fAPI.getStringBackgroundColor();
        this.penColor = fAPI.getPenPaintColor();
        this.currentScripts = vis.getScript();
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
        Element numberOfTurtlesType = createElement(NUM_TURTLES_TAG, Integer.toString(numTurtles));
        root.appendChild(numberOfTurtlesType);
        Element backgroundColorType = createElement(BACKGROUND_COLOR_TAG, background);
        root.appendChild(backgroundColorType);
        Element penColorType = createElement(PEN_COLOR_TAG, penColor.toString());
        root.appendChild(penColorType);
        Element currentScriptsType = createElement(CURRENT_SCRIPTS_TAG, currentScripts);
        root.appendChild(currentScriptsType);
        //Element paletteType = createElement(CURRENT_SCRIPTS_TAG, background);
        //root.appendChild(currentScriptsType);

    }
    /**
     * Creates a single element from a given tag name and text
     * @param tagName
     * @param text
     * @return documented element formatted with correct nodes
     */
    private Element createElement(String tagName, String text) {
        Element e = document.createElement(tagName);
        e.appendChild(document.createTextNode(text));
        return e;
    }

}

