package slogo.commands;

import slogo.Turtle;

public class LeftEx extends Executable {
    private Executable d;
    public LeftEx(Executable d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.left(d.runCommands(t));
    }
}
