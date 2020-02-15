package slogo.commands;

import slogo.Turtle;

public class PenDownEx extends Executable {
    @Override
    public int runCommands(Turtle t) {
        return t.penDown();
    }
}
