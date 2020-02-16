package slogo.commands;

import slogo.Turtle;

public class SetXYEx extends Executable {
    private Executable d1;
    private Executable d2;
    public SetXYEx(Executable d1, Executable d2){
        this.d1=d1;
        this.d2=d2;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.setXY(d1.runCommands(t), d2.runCommands(t));
    }
}
