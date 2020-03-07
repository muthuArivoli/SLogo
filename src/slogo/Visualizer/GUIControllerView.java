package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class GUIControllerView extends HBox{
  private static final String MOVE_FORWARD = "Move Forward";
  private static final String MOVE_BACKWARD = "Move Backward";
  private static final String TURN_RIGHT = "Turn Right";
  private static final String TURN_LEFT = "Turn Left";
  private static final Insets PADDING = new Insets(10, 10, 10, 10);


  public GUIControllerView(Button moveForwardButton, Button moveBackwardButton, Button turnRightButton, Button turnLeftButton) {
    moveForwardButton.setText(MOVE_FORWARD);
    moveBackwardButton.setText(MOVE_BACKWARD);
    turnRightButton.setText(TURN_RIGHT);
    turnLeftButton.setText(TURN_LEFT);
    this.getChildren().addAll(moveForwardButton, moveBackwardButton, turnLeftButton, turnRightButton);
    this.setPadding(PADDING);
  }
}
