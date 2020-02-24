package slogo.Visualizer;

import java.util.List;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class VariableView extends TextArea {
  private TextArea  variableText;
  public VariableView(String promptText) {
    variableText = new TextArea(promptText);
    variableText.setMaxSize(200,300);
  }

  private void displayVariables(List<String> variableList) {
    StringBuilder varText = new StringBuilder();
    for (String s: variableList) {
      varText.append(variableText.getText()).append("\n");
    }
    variableText.setText(varText.toString());
  }
}
