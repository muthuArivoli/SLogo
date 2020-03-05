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

  private Button moveForwardButton;
  private Button moveBackwardButton;
  private Button turnRightButton;
  private Button turnLeftButton;
  public GUIControllerView() {

    moveForwardButton = new Button(MOVE_FORWARD);
    moveBackwardButton = new Button (MOVE_BACKWARD);
    turnRightButton = new Button (TURN_RIGHT);
    turnLeftButton = new Button (TURN_LEFT);
    this.getChildren().addAll(moveForwardButton, moveBackwardButton, turnLeftButton, turnRightButton);
    this.setPadding(PADDING);
  }

  public Button getMoveForwardButton(){return moveForwardButton;}
  public Button getMoveBackwardButton(){return moveBackwardButton;}
  public Button getTurnRightButton(){return turnRightButton;}
  public Button getTurnLeftButton(){return turnLeftButton;}
}
