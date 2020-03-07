package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import slogo.configuration.Property;

public class MenuView {


    public static final int WIDTH_TEXTBOX = 150;
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