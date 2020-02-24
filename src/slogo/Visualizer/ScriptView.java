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
    private VBox scriptPane;
//    public ScriptView() {
//        this("");
//    }

    /**
     * Creates a new TextInputDialog with the default value entered into the
     * dialog {@link TextField}.
     */
//    public ScriptView(String defaultValue) {
//        scriptPane = new VBox();
//        // -- textarea
//        this.textArea = new TextArea(defaultValue);
//        this.textArea.setMaxWidth(Double.MAX_VALUE);
//        scriptPane.setVgrow(textArea, Priority.ALWAYS);
//
//        this.scriptPane.setMaxWidth(Double.MAX_VALUE);
//        this.scriptPane.setAlignment(Pos.CENTER_RIGHT);
//
//        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
//
//        updateGrid();
//
//        setResultConverter((dialogButton) -> {
//            ButtonBar.ButtonData data = dialogButton == null ? null : dialogButton.getButtonData();
//            return data == ButtonBar.ButtonData.OK_DONE ? textArea.getText() : null;
//        });
//    }
    public ScriptView() {
        textArea = new TextArea();
        textArea.setPrefSize(200, 600);
        scriptPane = new VBox(textArea);
    }

    public VBox getPane() {return scriptPane;}
    public String getScript() {
        return textArea.getText();
    }
}
