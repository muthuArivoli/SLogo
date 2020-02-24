package slogo.Visualizer;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class ScriptView extends Pane {

    private static final double VIEWWIDTH = 10;
    private static final double VIEWHEIGHT = 10;
    private TextArea textArea;
    public ScriptView() {
        this("");
    }

    /**
     * Creates a new TextInputDialog with the default value entered into the
     * dialog .
     */
    public ScriptView(String defaultValue) {
        // -- textarea
        textArea = new TextArea(defaultValue);
        textArea.setPrefSize(200, 300);

    }
//    public ScriptView() {
//        textArea = new TextArea();
//        textArea.setPrefSize(200, 300);
//        scriptPane = new VBox(textArea);
//    }

    public String getScript() {
        return textArea.getText();
    }
}
