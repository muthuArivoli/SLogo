package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.Map;

public class DashboardView extends Pane {
  private static final double SPACING = 30;
  private static final double MARGINS = 10;
  private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);

  private HistoryView pastScripts;
  private ScriptView script;
  private VariableView variableList;
  private TurtleInfoView turtleInfo;
  private VBox dashboardPane;
  public DashboardView() {
    dashboardPane = new VBox(SPACING);
    dashboardPane.prefHeightProperty().bind(this.heightProperty());
    dashboardPane.setPadding(PADDING);

    pastScripts = new HistoryView(this);
    script = new ScriptView();
    variableList = new VariableView();

    dashboardPane.setMaxWidth(Double.MAX_VALUE);
    dashboardPane.setAlignment(Pos.CENTER_RIGHT);
    VBox.setVgrow(script, Priority.ALWAYS);
    VBox.setVgrow(script, Priority.SOMETIMES);

    ScrollPane historyViewer = new ScrollPane();
    historyViewer.setContent(pastScripts);
    historyViewer.setPrefSize(100, 150);
    historyViewer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    historyViewer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

    dashboardPane.getChildren()
        .addAll(historyViewer, script, variableList);

    getChildren().add(dashboardPane);
    setHeight(dashboardPane.getMinHeight());
  }
  public VBox getDashboardPane() {
    return dashboardPane;
  }
  public void addVariables(Map<String, String> variables) {
    for (String varName: variables.keySet()) {
      if (!variableList.getItems().contains(varName)) {
        variableList.getItems().add(0, varName);
        variableList.getItems().add(1, variables.get(varName));
      } else {
        int i = variableList.getColumns().indexOf(varName);

      }
    }
  }
  public String getScript() { return script.getText();}
  public void setScript(String input) {script.setText(input);}
  protected HistoryView getPastScript() { return pastScripts;}
}
