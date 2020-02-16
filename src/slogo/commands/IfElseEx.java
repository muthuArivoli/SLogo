package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class IfElseEx extends Executable {
    private Executable d;
    private Executable trueCommands;
    private Executable falseCommands;
    public IfElseEx(){
        setParametersAmounts(3);
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
    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        d=parameters.get(0);
        trueCommands=parameters.get(1);
        falseCommands=parameters.get(2);
    }
}
