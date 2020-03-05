package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;


public class ScriptView extends TextArea {
    private static final String PLACEHOLDER = "Type your script here...";
    private static final int SCRIPT_HEIGHT = 225;

    public ScriptView() {
        super();
        this.setPromptText(PLACEHOLDER);
        this.setPrefHeight(SCRIPT_HEIGHT);
    }
}
