package slogo.Visualizer;

import javafx.scene.control.TextArea;
import slogo.configuration.Property;


public class ScriptView extends TextArea {
    private Property prop = new Property();
    private final String PLACEHOLDER = prop.getPropValues("prompt3");
    private static final int SCRIPT_HEIGHT = 225;

    public ScriptView() {
        super();
        this.setPromptText(PLACEHOLDER);
        this.setPrefHeight(SCRIPT_HEIGHT);
    }
}
