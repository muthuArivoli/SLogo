package slogo.commands;

import slogo.Turtle;

public class HomeEx extends Executable {
    @Override
    public int runCommands(Turtle t) {
        return t.home();
    }
}
