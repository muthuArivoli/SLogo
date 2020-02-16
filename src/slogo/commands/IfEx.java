package slogo.commands;

import slogo.Turtle;

public class IfEx extends Executable {
    private Executable d;
    private Executable e;
    public IfEx(Executable d, Executable e){
        this.d=d;
        this.e=e;
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        if(d.runCommands(t)!=0){
            ret=e.runCommands(t);
        }
        return ret;
    }
}
