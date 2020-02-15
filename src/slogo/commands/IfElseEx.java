package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class IfElseEx extends Executable {
    private Data d;
    private Executable trueCommands;
    private Executable falseCommands;
    public IfElseEx(Data d, Executable trueCommands, Executable falseCommands){
        this.d=d;
        this.trueCommands=trueCommands;
        this.falseCommands=falseCommands;
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        if(d.getData()!=0){
           ret=trueCommands.runCommands(t);
        }
        else{
            ret=falseCommands.runCommands(t);
        }
        return ret;
    }
}
