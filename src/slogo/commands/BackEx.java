package slogo.commands;

import slogo.Turtle;

public class BackEx extends Executable {
    private Executable d;
    public BackEx(Executable d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.back(d.runCommands(t));
    }

    @Override
    public int getParamAmount() {
        return 1;
    }
}
