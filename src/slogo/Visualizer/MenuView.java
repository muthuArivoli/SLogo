package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class MenuView extends Pane {

    private static final String MOVE_FORWARD = "Move Forward";
    private static final String MOVE_BACKWARD = "Move Backward";
    private static final String TURN_RIGHT = "Turn Right";
    private static final String TURN_LEFT = "Turn Left";

    public enum ButtonProperty {
        RUN,
    }
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
    private static final String STYLE_CSS = "button";
    private HBox menuPane;
    private ColorPicker picker;
    private Button runButton;
    private Button helpButton;
    private Button moveForwardButton;
    private Button moveBackwardButton;
    private Button turnRightButton;
    private Button turnLeftButton;
    private ComboBox langSelection;
    private Button fileButton;

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

        Region spacer1 = new Region();
        moveForwardButton = new Button (MOVE_FORWARD);
        moveBackwardButton = new Button (MOVE_BACKWARD);
        turnRightButton = new Button (TURN_RIGHT);
        turnLeftButton = new Button (TURN_LEFT);
        HBox center = new HBox(moveForwardButton, moveBackwardButton, turnLeftButton, turnRightButton);

        Region spacer2 = new Region();
        picker = new ColorPicker();
        runButton = new Button(RUN);
        fileButton = new Button(FILE);
        helpButton = new Button(HELP);
        HBox right = new HBox(helpButton, picker, fileButton, runButton);
        picker.setOnAction(event -> {
          turtle.updateBackgroundColor(picker.getValue());
        });
        langSelection.setPromptText(LANGUAGES);
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        spacer2.setMinSize(10, 0);
        spacer1.setMinSize(10, 0);
        menuPane.getChildren().addAll(langSelection, spacer1, center, spacer2, right);
        menuPane.setPadding(new Insets(10,10,10,10));
    }

    public HBox getPane() {return menuPane;}
    public Button getRunButton(){return runButton;}
    public ComboBox getLangSelection(){return langSelection;}
    public Button getFileButton(){return fileButton;}
    public Button getHelpButton(){return helpButton;}
    public Button getMoveForwardButton(){return moveForwardButton;}
    public Button getMoveBackwardButton(){return moveBackwardButton;}
    public Button getTurnRightButton(){return turnRightButton;}
    public Button getTurnLeftButton(){return turnLeftButton;}

}
