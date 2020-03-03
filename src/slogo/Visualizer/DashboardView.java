package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

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
    super();
    dashboardPane = new VBox(SPACING);
    dashboardPane.prefHeightProperty().bind(this.heightProperty());
    dashboardPane.setPadding(PADDING);

    pastScripts = new HistoryView();
    script = new ScriptView();
    variableList = new VariableView();

    dashboardPane.setMaxWidth(Double.MAX_VALUE);
    dashboardPane.setAlignment(Pos.CENTER_RIGHT);
    VBox.setVgrow(script, Priority.ALWAYS);

    dashboardPane.getChildren()
        .addAll(pastScripts, script, variableList);

    getChildren().add(dashboardPane);
    setHeight(dashboardPane.getMinHeight());
  }
  public VBox getDashboardPane() {
    return dashboardPane;
  }
  public String getScript() { return script.getText();}
  protected HistoryView getPastScript() { return pastScripts;}
}
