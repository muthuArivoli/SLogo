package slogo.commands;

import slogo.Turtle;

public class ClearScreenEx extends Executable {
    @Override
    public int runCommands(Turtle t) {
        return t.clearScreen();
    }
}
