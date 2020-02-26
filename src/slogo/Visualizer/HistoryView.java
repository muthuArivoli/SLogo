package slogo.Visualizer;

import javafx.scene.control.TextArea;

public class HistoryView extends TextArea {
  private TextArea historyText;
  private int counter;
  public HistoryView(String promptText) {
    counter = 0;
    historyText = new TextArea(promptText);
    historyText.setMinSize(100,100);
    historyText.setMaxSize(200,200);
  }

  protected void addScript(String script) {
    counter++;
    historyText.appendText("Script #" + counter + " ran:\n" + script + "\n\n");
  }
}
