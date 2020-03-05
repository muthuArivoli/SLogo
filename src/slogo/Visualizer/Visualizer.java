package slogo.Visualizer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import slogo.Turtle;

public class Visualizer {
    private static final double WIDTH_TEXTBOX = 80;
    private static Integer sceneLength = 700;
    private static Integer sceneWidth = 1300;
    private BorderPane rootPane;
    private Scene myScene;
    private TurtleView myTurtleView;
    private MenuView myMenu;
    private DashboardView myDashboard;
    private GUIControllerView myControls;


    public Visualizer() {

        myTurtleView = new TurtleView();
        myDashboard = new DashboardView();
        myMenu = new MenuView(myTurtleView);
        myControls = new GUIControllerView();


        getHelpButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Help Dialogue");
                alert.setHeaderText("Commands List");
                alert.setContentText("FORWARD/FD                [pixels]\n\n" +
                    "BACK/BK                           [pixels]\n\n" +
                    "LEFT/LT                             [degrees]\n\n" +
                    "RIGHT/RT                          [degrees]\n\n" +
                    "SETHEADING/SETH     [degrees]\n\n" +
                    "TOWARDS                        [x y]\n\n" +
                    "SETXY/GOTO                  [x y]\n\n" +
                    "PENDOWN/PD\n\n" +
                    "PENUP/PU\n\n" +
                    "SHOWTURTLE/ST\n\n" +
                    "HIDETURTLE/HT\n\n" +
                    "HOME\n\n" +
                    "CLEARSCREEN/CS\n\n");
                alert.show();
            }
        });

        rootPane = new BorderPane();
        myScene = new Scene(rootPane, sceneWidth, sceneLength);
        rootPane.setRight(myDashboard);
        rootPane.setCenter(myTurtleView.getPane());
        rootPane.setBottom(myControls);
        rootPane.setPadding(new Insets(10,10,10,10));
        rootPane.setTop(myMenu.getPane());

    }

//    public Property getProperty(ButtonProperty type) {
//        return switch (type) {
//            case RUN -> myRunProperty;
//        }
//    }
    public Scene getScene() {return myScene;}
    public Turtle addTurtle(int turtleNum){
        Turtle t = new Turtle((int) myTurtleView.getPane().getWidth(), (int) myTurtleView.getPane().getHeight(), turtleNum);
        myTurtleView.addGroup(t.getTurtleGroup());
        return t;
    }
    public void updateHistory(String script) {
        myDashboard.getPastScript().addScript(script);
    }

    public Button getRunButton(){return myMenu.getRunButton();}
    public ComboBox getLangSelection(){return myMenu.getLangSelection();}
    public Button getPaletteButton(){return myMenu.getPaletteButton();}
    public Button getFileButton(){return myMenu.getFileButton();}
    public Button getHelpButton(){return myMenu.getHelpButton();}
    public Button getMoveForwardButton(){return myControls.getMoveForwardButton();}
    public Button getMoveBackwardButton(){return myControls.getMoveBackwardButton();}
    public Button getTurnRightButton(){return myControls.getTurnRightButton();}
    public Button getTurnLeftButton(){return myControls.getTurnLeftButton();}
    public String getScript(){return myDashboard.getScript();}
    public void setScript(String input) {myDashboard.setScript(input);}
    public static Integer getSceneLength(){return sceneLength;}
    public static Integer getSceneWidth(){return sceneWidth;}

    public void alertCreator(String message1, String message2) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message1);
        alert.setContentText(message2);
        alert.showAndWait();
    }
}
