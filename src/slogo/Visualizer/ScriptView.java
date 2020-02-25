package slogo.Visualizer;

import javafx.geometry.Insets;
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
//    private HBox scriptRoot;
    private VBox scriptPane;

    public ScriptView() {
        textArea = new TextArea();
        textArea.setPrefSize(228, 600);
        scriptPane = new VBox(textArea);
//        scriptRoot = new HBox(scriptPane);
        VBox.setVgrow(textArea, Priority.ALWAYS);
        scriptPane.setPadding(new Insets(10,10,10,10));
//        HBox.setHgrow(scriptPane, Priority.ALWAYS);
    }

    public VBox getPane() {return scriptPane;}
    public String getScript() {
        return textArea.getText();
    }
}
