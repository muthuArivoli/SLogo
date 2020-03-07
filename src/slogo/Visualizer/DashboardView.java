package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import slogo.Variables.CVariable;

public class DashboardView extends Pane {
    private static final double SPACING = 30;
    private static final double MARGINS = 10;
    private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);
    private static final int PREF_WIDTH = 100;
    private static final int PREF_HEIGHT = 150;

    private HistoryView pastScripts;
    private ScriptView script;
    private VariableView variableList;

    DashboardView(Button saveVariablesButton) {
        VBox dashboardPane = new VBox(SPACING);
        dashboardPane.prefHeightProperty().bind(this.heightProperty());
        dashboardPane.setPadding(PADDING);

        pastScripts = new HistoryView(this);
        script = new ScriptView();
        variableList = new VariableView(saveVariablesButton);


        dashboardPane.setMaxWidth(Double.MAX_VALUE);
        dashboardPane.setAlignment(Pos.CENTER_RIGHT);
        VBox.setVgrow(script, Priority.ALWAYS);

        ScrollPane historyViewer = new ScrollPane();
        historyViewer.setContent(pastScripts);
        historyViewer.setPrefSize(PREF_WIDTH, PREF_HEIGHT);
        historyViewer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        historyViewer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        dashboardPane.getChildren()
                .addAll(historyViewer, script, variableList);

        getChildren().add(dashboardPane);
        setHeight(dashboardPane.getMinHeight());
    }
    public void setScript(String input) {
        script.setText(input);
    }
    public void setPastScript(HistoryView input) {
        pastScripts = input;
    }

    TableView<CVariable> getVariableTable() {
        return variableList.getTable();
    }

    String getScript() {
        return script.getText();
    }

    HistoryView getPastScript() {
        return pastScripts;
    }

    String getPastScriptViaXML() {
        StringBuilder sb = new StringBuilder();
        for (Node node : pastScripts.getChildren()) {
            if (node instanceof Text) {
                sb.append(((Text) node).getText());
            }
            else{
                sb.append(node);
            }
        }
        return sb.toString();
    }
}
