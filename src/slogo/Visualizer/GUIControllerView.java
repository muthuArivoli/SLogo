package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import slogo.configuration.Property;

public class GUIControllerView extends HBox{
  private Property prop = new Property();
  private final String MOVE_FORWARD = prop.getPropValues("button9");
  private final String MOVE_BACKWARD = prop.getPropValues("button10");
  private final String TURN_RIGHT = prop.getPropValues("button11");
  private final String TURN_LEFT = prop.getPropValues("button12");
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
