package slogo.commands;

import slogo.Turtle;

public class IfElseEx extends Executable {
    private Executable d;
    private Executable trueCommands;
    private Executable falseCommands;
    public IfElseEx(Executable d, Executable trueCommands, Executable falseCommands){
        this.d=d;
        this.trueCommands=trueCommands;
        this.falseCommands=falseCommands;
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        if(d.runCommands(t)!=0){
           ret=trueCommands.runCommands(t);
        }
        else{
            ret=falseCommands.runCommands(t);
        }
        return ret;
    }
}
