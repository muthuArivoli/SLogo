package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import slogo.Variables.CVariable;

public class DashboardView extends Pane {
  private static final double SPACING = 30;
  private static final double MARGINS = 10;
  private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);

  private HistoryView pastScripts;
  private ScriptView script;
  private VariableView variableList;
  private VBox dashboardPane;
  public DashboardView(Button saveVariablesButton) {
    dashboardPane = new VBox(SPACING);
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
    historyViewer.setPrefSize(100, 150);
    historyViewer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    historyViewer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

    dashboardPane.getChildren()
        .addAll(historyViewer, script, variableList);
    
    getChildren().add(dashboardPane);
    setHeight(dashboardPane.getMinHeight());
  }
  public void addGroup(Group toAdd){
    dashboardPane.getChildren().addAll(toAdd);
  }

  public VBox getDashboardPane() {
    return dashboardPane;
  }
  public TableView<CVariable> getVariableTable() {
    return variableList.getTable();
  }
public String getScript() { return script.getText();}
public void setScript(String input) {script.setText(input);}
public HistoryView getPastScript() { return pastScripts;}
public void setPastScript(HistoryView input) {pastScripts = input;}
}
