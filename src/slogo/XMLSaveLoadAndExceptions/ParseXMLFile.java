package slogo.XMLSaveLoadAndExceptions;

import java.io.File;
import javafx.scene.paint.Color;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * This class handles all of the document building and grabbing data
 * of the XML file, to compartmentalize and organize Visualizer
 */
public class ParseXMLFile {

    public static final String DEFAULT_NUM_TURTLES_TAG = "1";
    public static final String DEFAULT_BACKGROUND_COLOR_TAG = "";
    public static final String DEFAULT_CURRENT_SCRIPTS_TAG = "";
    public static final String DEFAULT_PAINT_COLOR_TAG = "";
    public static final String DEFAULT_PAST_SCRIPTS_TAG = "";


    public static final String UNKNOWN_TAG_ERROR = "The tag %s was not found. Variable has been filled with default value: %s";

    private String filename;
    private String backgroundColor;
    private Color penColor;
    private String currentScripts;
    private String pastScripts;
    private Element mainElement;
    private int numTurtles;
    private boolean parseFail;


    public ParseXMLFile(String filename){
        this.filename = filename;
        readXMLFile();

    }

    /**
     * Reads XML file specified by the filename and sets basic variables
     */
    private boolean readXMLFile() {
        try {
            File file = new File(filename);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("slogo");
            mainElement = (Element) nodeList.item(0);

            numTurtles = getIntegerElementByTag("numTurtles", DEFAULT_NUM_TURTLES_TAG);
            backgroundColor = getStringElementByTag("background", DEFAULT_BACKGROUND_COLOR_TAG);
            currentScripts = getStringElementByTag("currentScripts", DEFAULT_CURRENT_SCRIPTS_TAG);
            penColor = Color.web(getStringElementByTag("penColor", DEFAULT_PAINT_COLOR_TAG));
            pastScripts = getStringElementByTag("pastScripts", DEFAULT_PAST_SCRIPTS_TAG);



            parseFail = false;
            return true;
        }
        catch (Exception e) {
            String errorMessage = "Could not parse given file: " + filename +"\n Check Tag information in README for proper tagging.";
            System.out.println(errorMessage);
            parseFail = true;
            return false;
        }
    }

    /**
     * Getter methods to access all of the basic attributes of the board.
     * These apply to every board
     * @return
     */
    public Integer getNumTurtlesFromAnInputtedFile() {return numTurtles; }
    public String getBackgroundColorFromAnInputtedFile() {return backgroundColor; }
    //need dash in front end API
    public String getCurrentScriptFromAnInputtedFile() {return currentScripts;}
    public String getPastScriptFromAnInputtedFile() {return pastScripts;}

    public Color getPenColorFromAnInputtedFile() {return penColor;}
    public boolean getFailStatus(){return parseFail;}

    private String getStringElementByTag (String tagName, String defaultVal) throws ParserException {
        if(mainElement.getElementsByTagName(tagName).getLength() == 0) {
            new ParserException(String.format(UNKNOWN_TAG_ERROR, tagName, defaultVal));
            return defaultVal;
        }
        return mainElement.getElementsByTagName(tagName).item(0).getTextContent();
    }

    /**
     * Converts the string within tag tagName to an Integer
     * @param tagName
     * @return
     */
    private int getIntegerElementByTag(String tagName, String defaultVal) {
        return Integer.parseInt(getStringElementByTag(tagName, defaultVal));
    }

}
