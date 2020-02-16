package slogo.commands;

import slogo.Turtle;


public class HideTurtleEx extends Executable {

    @Override
    public int runCommands(Turtle t) {
        return t.hideTurtle();
    }

}
