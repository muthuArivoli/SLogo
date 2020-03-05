package slogo.Visualizer;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VariableView extends TableView {

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
