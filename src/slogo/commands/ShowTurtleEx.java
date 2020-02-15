package slogo.commands;

import slogo.Turtle;

public class ShowTurtleEx extends Executable {
    @Override
    public int runCommands(Turtle t) {
        return t.showTurtle();
    }
}
