package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private static final String LANGUAGES = "Languages";
    private HBox menuPane;

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

        ComboBox left = new ComboBox(options);
        Pane spacer = new Pane();
        Button right = new Button(RUN);
        //right.setOnMouseClicked();

        left.setPromptText(LANGUAGES);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 0);
        menuPane.getChildren().addAll(left, spacer, right);
    }


    public HBox getPane() {return menuPane;}
}
