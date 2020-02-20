package slogo.Visualizer;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class ScriptView extends Pane {

    private static final double VIEWWIDTH = 10;
    private static final double VIEWHEIGHT = 10;
    private VBox scriptPane;

    public ScriptView() {
        TextArea textArea = new TextArea();
        textArea.setPrefSize(200, 600);
        scriptPane = new VBox(textArea);
    }

    public VBox getPane() {return scriptPane;}
}
