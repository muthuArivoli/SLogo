package slogo.Visualizer;

import javafx.scene.control.TextArea;

public class HistoryView extends TextArea {
  private static final String PLACEHOLDER = "This shows previously ran scripts";
  private TextArea historyText;
  private int counter;
  public HistoryView() {
    super();
    this.setPromptText(PLACEHOLDER);
    this.setMinHeight(150);
    counter = 0;
  }

  protected void addScript(String script) {
    counter++;
    this.appendText("Script #" + counter + " ran:\n" + script + "\n\n");
  }
}
