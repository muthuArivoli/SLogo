package slogo.Visualizer;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class ScriptView extends Pane {

    private static final double VIEWWIDTH = 10;
    private static final double VIEWHEIGHT = 10;
    private TextArea textArea;
//    public ScriptView() {
//        this("");
//    }
//
//    /**
//     * Creates a new TextInputDialog with the default value entered into the
//     * dialog .
//     */
//    public ScriptView(String defaultValue) {
//        // -- textarea
//        textArea = new TextArea(defaultValue);
//        textArea.setPrefSize(200, 300);
//    private HBox scriptRoot;
    private VBox scriptPane;

    public ScriptView() {
        textArea = new TextArea();
        textArea.setPrefSize(228, 600);
        scriptPane = new VBox(textArea);
//        scriptRoot = new HBox(scriptPane);
        VBox.setVgrow(textArea, Priority.ALWAYS);
//        HBox.setHgrow(scriptPane, Priority.ALWAYS);
    }
    public String getScript() {
        return textArea.getText();
    }
}
