package slogo.commands;

import slogo.Turtle;

public class TowardsEx extends Executable {
    private Executable d1;
    private Executable d2;
    public TowardsEx(Executable d1, Executable d2){
        this.d1=d1;
        this.d2=d2;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.towards(d1.runCommands(t), d2.runCommands(t));
    }
}
