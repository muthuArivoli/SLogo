package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import slogo.BackEndAPI;
import slogo.XMLSaveLoadAndExceptions.ParseXMLFile;
import slogo.Turtle;

public class MenuView extends Pane {
    private static final double HBOX_SPACING = 5;
    public static final int WIDTH_TEXTBOX = 80;
    private static final int ENTRY_PADDING = 100;

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
    private ComboBox langSelection;
    private Button fileButton;
    private Button loadEnvironmentButton;
    private Button loadButton;
    public MenuView(TurtleView turtle) {
        menuPane = new HBox();
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
        langSelection = new ComboBox(options);
        helpButton = new Button(HELP);
        paletteButton = new Button(PALLETE);
        picker = new ColorPicker();
        Pane spacer = new Pane();
        runButton = new Button(RUN);
        loadButton = new Button(LOAD);
        saveButton = new Button(SAVE);
        fileButton = new Button(FILE);
        helpButton = new Button(HELP);
        loadEnvironmentButton = new Button(LOAD);

        Label savePrompt = new Label(FILE_SAVE_PROMPT);
        TextField saveTextField = new TextField ();
        saveTextField.setMaxWidth(WIDTH_TEXTBOX);
        saveButton.setOnAction(e -> Turtle.createXMLFile((saveTextField.getText())));

        Label loadPrompt = new Label(FILE_ENTRY_PROMPT);
        TextField loadTextField = new TextField();
        loadTextField.setMaxWidth(WIDTH_TEXTBOX);
        loadEnvironmentButton.setOnAction(e -> loadEnvironment(loadTextField.getText(), turtle));

        HBox right = new HBox(helpButton, picker, fileButton, runButton, savePrompt, saveTextField, saveButton, loadPrompt, loadTextField, loadEnvironmentButton);

        picker.setOnAction(event -> {
          turtle.updateBackgroundColor(picker.getValue());
        });
        langSelection.setPromptText(LANGUAGES);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(5, 0);
        menuPane.getChildren().addAll(langSelection, paletteButton, spacer, right);
        menuPane.setPadding(new Insets(10,10,10,10));
    }
    private void loadEnvironment(String input, TurtleView turtle){
        ParseXMLFile newlyParsedFile = new ParseXMLFile(String.format("data/%s.xml", input));
        turtle.setBackgroundColorUsingXML(newlyParsedFile.getBackgroundColorFromAnInputtedFile());
        for(int i = 0; i<newlyParsedFile.getNumTurtlesFromAnInputtedFile(); i++){
            // add a turtle via the backend command
        }
    }

    public HBox getPane() {return menuPane;}
    public Button getRunButton(){return runButton;}
    public ComboBox getLangSelection(){return langSelection;}
    public Button getFileButton(){return fileButton;}
    public Button getHelpButton(){return helpButton;}
    public Button getPaletteButton() {return paletteButton;}
}