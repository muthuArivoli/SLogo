package slogo.Visualizer;

import java.util.Map;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
  private static final double MARGINS = 10;
  private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);
  private static final String PLACEHOLDER = "This shows the list of variables";
  private static final String SAVE_CHANGES = "Save Changes";
  private TableView<CVariable> variableTable;
  private Button saveVariable;
  public VariableView() {
    super();
    variableTable = new TableView<>();
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

    saveVariable = new Button(SAVE_CHANGES);
    saveVariable.setPadding(PADDING);
    this.getChildren().addAll(variableTable, saveVariable);
    this.setPrefHeight(200);
  } 

  public TableView<CVariable> getVariableTable() {
    return variableTable;
  }
  public Button getSaveVariableButton() {
    return saveVariable;
  }
}
