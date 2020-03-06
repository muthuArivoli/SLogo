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

public class MenuView {


    public static final int WIDTH_TEXTBOX = 150;
    private static final int ENTRY_PADDING = 100;
  private static final Insets PADDING = new Insets(10, 10, 10, 10);

    public static final String FILE_ENTRY_PROMPT = " Please enter file name: ";
    public static final String FILE_SAVE_PROMPT= "  Save as file name: ";

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
    private static final String PALETTE = "Palette";
    private static final String SAVE = "Save";
    private static final String LANGUAGES = "Languages";
    private static final String STYLE_CSS = "button";


    public MenuView(HBox menuPane, ColorPicker picker, Button runButton, Button saveButton,
                    Button helpButton, Button paletteButton, Button penButton, Button fileButton, Button loadEnvironmentButton,
                    ComboBox langSelection, TextField loadTextField, TextField saveTextField) {

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

        runButton.setText(RUN);
        saveButton.setText(SAVE);
        fileButton.setText(FILE);
        helpButton.setText(HELP);
        loadEnvironmentButton.setText(LOAD);
//
//        Region smallSpacer1 = new Region();
//        smallSpacer1.maxWidth(10);
//        Region smallSpacer2 = new Region();
//        smallSpacer2.maxWidth(10);

        Label savePrompt = new Label(FILE_SAVE_PROMPT);

        saveTextField.setMaxWidth(WIDTH_TEXTBOX);
        saveTextField.setPromptText(FILE_SAVE_PROMPT);

        loadTextField.setMaxWidth(WIDTH_TEXTBOX);
        loadTextField.setPromptText(FILE_ENTRY_PROMPT);

        HBox center = new HBox(saveTextField, saveButton, loadTextField, loadEnvironmentButton);
        HBox right = new HBox(helpButton, picker, fileButton, runButton);

        langSelection.setPromptText(LANGUAGES);

        HBox.setHgrow(spacer1, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        menuPane.getChildren().addAll(langSelection, paletteButton, penButton, spacer1, center, spacer2, right);
        menuPane.setPadding(new Insets(10,10,10,10));
    }
}