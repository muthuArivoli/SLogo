package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;


public class ScriptView extends TextArea {
    private static final double MARGINS = 10;
    private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);
    private static final String PLACEHOLDER = "Type your script here...";

    public ScriptView() {
        super();
        this.setPromptText(PLACEHOLDER);
        this.setPrefHeight(300);
    }
}
