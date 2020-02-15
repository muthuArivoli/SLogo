package slogo.commands;

import slogo.Turtle;

public class PenUpEx extends Executable {
    @Override
    public int runCommands(Turtle t) {
        return t.penUp();
    }
}
