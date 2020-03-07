package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import slogo.Turtle;
import slogo.XMLSaveLoadAndExceptions.ParseXMLFile;
import slogo.configuration.Property;

public class MenuView {


    public static final int WIDTH_TEXTBOX = 150;
    private static final int ENTRY_PADDING = 100;
    private static final Insets PADDING = new Insets(10, 10, 10, 10);

    private Property prop = new Property();
    private final String FILE_ENTRY_PROMPT = prop.getPropValues("prompt1");
    private final String FILE_SAVE_PROMPT= prop.getPropValues("prompt2");

    private final String CHINESE = prop.getPropValues("langChin");
    private final String ENGLISH = prop.getPropValues("langEngl");
    private final String FRENCH = prop.getPropValues("langFren");
    private final String GERMAN = prop.getPropValues("langGerm");
    private final String ITALIAN = prop.getPropValues("langItal");
    private final String PORTUGUESE = prop.getPropValues("langPort");
    private final String RUSSIAN = prop.getPropValues("langRuss");
    private final String SPANISH = prop.getPropValues("langSpan");
    private final String URDU = prop.getPropValues("langUrdu");
    private final String RUN = prop.getPropValues("button1");
    private final String PEN = prop.getPropValues("button2");
    private final String FILE = prop.getPropValues("button3");
    private final String LOAD =  prop.getPropValues("button4");
    private final String HELP = prop.getPropValues("button5");
    private final String PALETTE = prop.getPropValues("button6");
    private final String SAVE = prop.getPropValues("button7");
    private final String LANGUAGES = prop.getPropValues("button8");
    private final String STYLE_CSS = "button";

    public MenuView(HBox menuPane, ColorPicker picker, Button runButton, Button saveButton,
                    Button helpButton, Button paletteButton, Button penButton, Button fileButton, Button loadEnvironmentButton,
                    ComboBox langSelection, TextField loadTextField, TextField saveTextField) {

<<<<<<< HEAD
=======
  public enum ButtonProperty {
        RUN,
    }
    public static final String FILE_ENTRY_PROMPT = " Please enter file name: ";
    public static final String FILE_SAVE_PROMPT= "  Save as file name: ";
    private static final double VIEWWIDTH = 10;
    private static final double VIEWHEIGHT = 10;

    private static final String CHINESE = "Chinese";
    private static final String ENGLISH = "English";
    private static final String FRENCH = "French";
    private static final String GERMAN = "German";
    private static final String ITALIAN = "Italian";
    private static final String PORTUGUESE = "Portuguese";
    private static final String RUSSIAN = "Russian";
    private static final String SPANISH = "Spanish";
    private static final String URDU = "Urdu";
    private static final String RUN = "Run";
    private static final String PEN = "Pen";
    private static final String FILE = "Run Command File";
    private static final String LOAD =  "Load File";
    private static final String HELP = "Help";
    private static final String PALLETE = "Pallete";
    private static final String SAVE = "Save";
    private static final String LANGUAGES = "Languages";
    private static final String STYLE_CSS = "button";
    private HBox menuPane;
    private StackPane intro;

    private ColorPicker picker;
    private Button runButton;
    private Button saveButton;
    private Button helpButton;
    private Button paletteButton;
    private Button penButton;
    private ComboBox langSelection;
    private Button fileButton;
    private Button loadEnvironmentButton;
    private TextField loadTextField;
    private TextField saveTextField;
    public MenuView(TurtleView turtle) {
        menuPane = new HBox();
>>>>>>> jdm
        ObservableList<String> options =
                FXCollections.observableArrayList(
                    CHINESE,
                    ENGLISH,
                    FRENCH,
                    GERMAN,
                    ITALIAN,
                    PORTUGUESE,
                    RUSSIAN,
                    SPANISH,
                    URDU
                );
        langSelection.setItems(options);

        paletteButton.setText(PALETTE);
        penButton.setText(PEN);

        Region spacer1 = new Region();
        Region spacer2 = new Region();
<<<<<<< HEAD

        runButton.setText(RUN);
        saveButton.setText(SAVE);
        fileButton.setText(FILE);
        helpButton.setText(HELP);
        loadEnvironmentButton.setText(LOAD);

        Label savePrompt = new Label(FILE_SAVE_PROMPT);

        saveTextField.setMaxWidth(WIDTH_TEXTBOX);
        saveTextField.setPromptText(FILE_SAVE_PROMPT);

=======
        picker = new ColorPicker();
        runButton = new Button(RUN);
        saveButton = new Button(SAVE);
        fileButton = new Button(FILE);
        penButton = new Button(PEN);
        helpButton = new Button(HELP);
        loadEnvironmentButton = new Button(LOAD);
//
//        Region smallSpacer1 = new Region();
//        smallSpacer1.maxWidth(10);
//        Region smallSpacer2 = new Region();
//        smallSpacer2.maxWidth(10);

        Label savePrompt = new Label(FILE_SAVE_PROMPT);
        saveTextField = new TextField();
        saveTextField.setMaxWidth(WIDTH_TEXTBOX);
        saveTextField.setPromptText(FILE_SAVE_PROMPT);

        loadTextField = new TextField();
>>>>>>> jdm
        loadTextField.setMaxWidth(WIDTH_TEXTBOX);
        loadTextField.setPromptText(FILE_ENTRY_PROMPT);

        HBox center = new HBox(saveTextField, saveButton, loadTextField, loadEnvironmentButton);
        HBox right = new HBox(helpButton, picker, fileButton, runButton);
<<<<<<< HEAD

        langSelection.setPromptText(LANGUAGES);

        HBox.setHgrow(spacer1, Priority.ALWAYS);
=======
            picker.setOnAction(event -> {
          turtle.updateBackgroundColor(picker.getValue());
        });

        langSelection.setPromptText(LANGUAGES);
>>>>>>> jdm
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        menuPane.getChildren().addAll(langSelection, paletteButton, penButton, spacer1, center, spacer2, right);
        menuPane.setPadding(new Insets(10,10,10,10));
    }
<<<<<<< HEAD
=======


    public HBox getPane() {return menuPane;}
    public Button getRunButton(){return runButton;}
    public ComboBox getLangSelection(){return langSelection;}
    public Button getFileButton(){return fileButton;}
    public Button getHelpButton(){return helpButton;}
    public Button getPenButton(){return penButton;}
    public Button getSaveButton(){return saveButton;}
    public Button getLoadEnvironmentButtonButton(){return loadEnvironmentButton;}
    public TextField getSaveTextField(){return saveTextField;}
    public TextField getLoadTextField(){return loadTextField;}

    public Button getPaletteButton() {return paletteButton;}
>>>>>>> jdm
}