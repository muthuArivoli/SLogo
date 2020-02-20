package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuView extends Pane {

    private static final double VIEWWIDTH = 10;
    private static final double VIEWHEIGHT = 10;
    private HBox menuPane;

    public MenuView() {
        menuPane = new HBox();

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Chinese",
                        "English",
                        "French",
                        "German",
                        "Italian",
                        "Portuguese",
                        "Russian",
                        "Spanish",
                        "Urdu"
                );

        ComboBox left = new ComboBox(options);
        Pane spacer = new Pane();
        Button right = new Button("Run");

        left.setPromptText("Languages");
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 0);
        menuPane.getChildren().addAll(left, spacer, right);
    }

    public HBox getPane() {return menuPane;}
}
