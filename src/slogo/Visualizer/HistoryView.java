package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

public class HistoryView extends TextFlow {
  private static final int MIN_WIDTH = 500;
  private static final int MIN_HEIGHT = 200;
  private int counter;
  private DashboardView dashBoardView;
  public HistoryView(DashboardView dbView) {
    super();
    this.setMinWidth(MIN_WIDTH);
    this.setMinHeight(MIN_HEIGHT);
    this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    counter = 0;
    dashBoardView = dbView;
    }

  protected void addScript(String input) {
    counter++;
    Text text_1 = new Text("  Script #" + counter + " ran:\n");

    Hyperlink script_link = new Hyperlink(input);
    Text text_2 = new Text("\n\n");
    this.getChildren().addAll(text_1, script_link, text_2);
    script_link.setOnAction(e -> dashBoardView.setScript(input));
  }
}
