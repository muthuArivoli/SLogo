package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class HistoryView extends TextFlow {
  private static final String PLACEHOLDER = "This shows previously ran scripts";
  private TextFlow historyText;
  private int counter;
  public HistoryView() {
    super();
    this.setMinWidth(500);
    this.setMinHeight(140);
    this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    counter = 0;
  }

  protected void addScript(String script) {
    counter++;
    Text text_1 = new Text("  Script #" + counter + " ran:\n");
    Hyperlink script_link = new Hyperlink(script);
    Text text_2 = new Text("\n\n");
    this.getChildren().addAll(text_1, script_link, text_2);
  }
}
