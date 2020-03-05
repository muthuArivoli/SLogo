package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import slogo.BackEndAPI;
import slogo.FrontEndAPI;
import slogo.XMLSaveLoadAndExceptions.ParseXMLFile;
import slogo.Turtle;

public class MenuView {


    private static final double HBOX_SPACING = 5;
    public static final int WIDTH_TEXTBOX = 150;
    private static final int ENTRY_PADDING = 100;
  private static final Insets PADDING = new Insets(10, 10, 10, 10);

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

        Region spacer1 = new Region();

        Region spacer2 = new Region();
        picker = new ColorPicker();
        runButton = new Button(RUN);
        loadButton = new Button(LOAD);
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
        TextField saveTextField = new TextField();
        saveTextField.setMaxWidth(WIDTH_TEXTBOX);
        saveTextField.setPromptText(FILE_SAVE_PROMPT);
        saveButton.setOnAction(e -> Turtle.createXMLFile((saveTextField.getText())));

        TextField loadTextField = new TextField();
        loadTextField.setMaxWidth(WIDTH_TEXTBOX);
        loadTextField.setPromptText(FILE_ENTRY_PROMPT);
        loadEnvironmentButton.setOnAction(e -> loadEnvironment(loadTextField.getText(), turtle));
        HBox center = new HBox(saveTextField, saveButton, loadTextField, loadEnvironmentButton);
        HBox right = new HBox(helpButton, picker, fileButton, runButton);
        picker.setOnAction(event -> {
          turtle.updateBackgroundColor(picker.getValue());
        });
        langSelection.setPromptText(LANGUAGES);
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        menuPane.getChildren().addAll(langSelection, paletteButton, penButton, spacer1, center, spacer2, right);
        menuPane.setPadding(PADDING);
    }
    private void loadEnvironment(String input, TurtleView turtle){
        ParseXMLFile newlyParsedFile = new ParseXMLFile(String.format("data/%s.xml", input));
        turtle.setBackgroundColorUsingXML(newlyParsedFile.getBackgroundColorFromAnInputtedFile());
        for(int i = 0; i< newlyParsedFile.getNumTurtlesFromAnInputtedFile(); i++){
            Group ret = new Group();
            Turtle addTurtle = new Turtle(5, 5, 1);
            ret.getChildren().addAll(addTurtle.getTurtleGroup());
            System.out.print(i);
        }
    }

    public HBox getPane() {return menuPane;}
    public Button getRunButton(){return runButton;}
    public ComboBox getLangSelection(){return langSelection;}
    public Button getFileButton(){return fileButton;}
    public Button getHelpButton(){return helpButton;}
    public Button getPenButton(){return penButton;}
    public Button getPaletteButton() {return paletteButton;}
}