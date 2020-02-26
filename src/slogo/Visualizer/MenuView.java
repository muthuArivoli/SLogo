package slogo.Visualizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MenuView extends Pane {
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
    private static final String LANGUAGES = "Languages";
    private static final String STYLE_CSS = "button";
    private static final String HELP_PAGE = "https://www2.cs.duke.edu/courses/spring20/compsci308/assign/03_parser/commands.php";
    private HBox menuPane;
    private ColorPicker picker;
    private Button run;
    Hyperlink help;

    public MenuView(GridView grid) {
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
        help = new Hyperlink();

        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        help.setText("Help...");

        Pane spacer = new Pane();
        run = new Button(RUN);

        picker = new ColorPicker();
        picker.setOnAction(event -> {
            grid.updateBackgroundColor(picker.getValue());
        });
        left.setPromptText(LANGUAGES);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 0);
        menuPane.getChildren().addAll(left, help, spacer, picker, run);
    }

    public HBox getPane() {return menuPane;}
}
