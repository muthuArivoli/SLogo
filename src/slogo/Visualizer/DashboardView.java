package slogo.Visualizer;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class DashboardView extends Pane {

  private VBox dashboardPane;
  public DashboardView() {
    dashboardPane = new VBox();
    ScriptView script = new ScriptView();
    VariableView variables = new VariableView();
    dashboardPane.getChildren().addAll(script,variables);

    dashboardPane.setMaxWidth(Double.MAX_VALUE);
    dashboardPane.setAlignment(Pos.CENTER_RIGHT);
  }
  public VBox getDashboardPane() {
    return dashboardPane;
  }
}
