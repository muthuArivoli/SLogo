package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class MenuView extends Pane {

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
    private static final String FILE = "Run File";
    private static final String HELP = "Help";
    private static final String LANGUAGES = "Languages";
    private HBox menuPane;
    private Button runButton;
    private Button helpButton;
    private ComboBox langSelection;
    private Button fileButton;

    public MenuView() {
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
        Pane spacer = new Pane();
        runButton = new Button(RUN);
        fileButton = new Button(FILE);
        helpButton = new Button(HELP);
        HBox right = new HBox(helpButton, fileButton, runButton);
        langSelection.setPromptText(LANGUAGES);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 0);
        menuPane.getChildren().addAll(langSelection, spacer, right);
        menuPane.setPadding(new Insets(10,10,10,10));
    }
    public HBox getPane() {return menuPane;}
    public Button getRunButton(){return runButton;}
    public ComboBox getLangSelection(){return langSelection;}
    public Button getFileButton(){return fileButton;}
    public Button getHelpButton(){return helpButton;}
}
