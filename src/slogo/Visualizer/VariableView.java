package slogo.Visualizer;

import java.util.Map;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextArea;

import java.util.List;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import slogo.Variables.CVariable;

public class VariableView extends VBox {
  private static final String SAVE_CHANGES = "Save Changes";
  private TableView<CVariable> variableTable;

  public VariableView(Button saveVariablesButton) {
    super();
    variableTable = new TableView<>();
    variableTable.setPrefHeight(200);

    TableColumn<CVariable, String> variableNameColumn = new TableColumn<>("Variable Name");
    variableNameColumn.setMinWidth(300);
    variableNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<CVariable, String> variableValueColumn = new TableColumn<>("Value");
    variableValueColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
    variableValueColumn.setMinWidth(200);
    variableValueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    variableValueColumn.setOnEditCommit(event -> {
      variableTable.getItems().get(event.getTablePosition().getRow()).setData(Integer.parseInt(event.getNewValue()));
    });
    variableNameColumn.setEditable(true);
    variableTable.getColumns().addAll(variableNameColumn, variableValueColumn);

    saveVariablesButton.setText(SAVE_CHANGES);

    this.getChildren().addAll(variableTable, saveVariablesButton);
  } 

  public TableView<CVariable> getTable() {
    return variableTable;
  }
}
