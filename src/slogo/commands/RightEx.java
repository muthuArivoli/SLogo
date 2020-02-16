package slogo.commands;

import slogo.Turtle;

public class RightEx extends Executable {
    private Executable d;
    public RightEx(Executable d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.left(d.runCommands(t));
    }
}
