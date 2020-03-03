package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;

import java.util.List;

public class VariableView extends TextArea {
  private static final double MARGINS = 10;
  private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);
  private static final String PLACEHOLDER = "This shows the list of variables";
  public VariableView() {
    super();
    this.setPromptText(PLACEHOLDER);
    this.setMinHeight(150);
  }

  private void displayVariables(List<String> variableList) {
    StringBuilder varText = new StringBuilder();
    for (String s: variableList) {
      varText.append(this.getText()).append("\n");
    }
    this.setText(varText.toString());
  }
}
