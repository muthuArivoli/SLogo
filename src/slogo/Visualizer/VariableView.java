package slogo.Visualizer;

import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextArea;

import java.util.List;

public class VariableView extends TableView {
  private static final double MARGINS = 10;
  private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);
  private static final String PLACEHOLDER = "This shows the list of variables";

  public VariableView() {
    TableColumn<String, String> variableNameColumn = new TableColumn<>("Variable Name");
    variableNameColumn.setCellValueFactory(new PropertyValueFactory<>("variableName"));

    TableColumn<String, String> variableValueColumn = new TableColumn<>("Value");
    variableNameColumn.setCellValueFactory(new PropertyValueFactory<>("variableValue"));
    this.getColumns().addAll(variableNameColumn, variableValueColumn);
    this.setPrefHeight(200);
  } 

//  private void displayVariables(Map<String, String> variableList) {
//    StringBuilder varText = new StringBuilder();
//    for (String s: variableList) {
//      varText.append(this.getText()).append("\n");
//    }
//    this.setText(varText.toString());
//  }
}
