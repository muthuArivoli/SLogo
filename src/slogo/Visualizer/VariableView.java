package slogo.Visualizer;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import slogo.Variables.CVariable;

public class VariableView extends VBox {
  private static final String SAVE_CHANGES = "Save Changes";
  private static final int MIN_COLUMN_WIDTH = 250;
  private static final int PREF_TABLE_HEIGHT = 200;
  private static final String VARIABLE_NAME = "Variable Name";
  private static final String VALUE = "Value";
  private TableView<CVariable> variableTable;

  public VariableView(Button saveVariablesButton) {
    super();
    variableTable = new TableView<>();
    variableTable.setPrefHeight(PREF_TABLE_HEIGHT);
    variableTable.setEditable(true);

    TableColumn<CVariable, String> variableNameColumn = new TableColumn<>(VARIABLE_NAME);
    variableNameColumn.setMinWidth(MIN_COLUMN_WIDTH);
    variableNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<CVariable, String> variableValueColumn = new TableColumn<>(VALUE);
    variableValueColumn.setCellValueFactory(new PropertyValueFactory<>("dataTable"));
    variableValueColumn.setMinWidth(MIN_COLUMN_WIDTH);
    variableValueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    variableValueColumn.setOnEditCommit(event -> {
      variableTable.getItems().get(event.getTablePosition().getRow()).setData(Integer.parseInt(event.getNewValue()));
    });
    variableNameColumn.setEditable(true);
    variableTable.getColumns().addAll(variableNameColumn, variableValueColumn);

    saveVariablesButton.setText(SAVE_CHANGES);

    this.getChildren().addAll(variableTable, saveVariablesButton);
  } 

  protected TableView<CVariable> getTable() {
    return variableTable;
  }
}
