package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class IfEx extends Executable {
    private Executable d;
    private Executable e;
    public IfEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        if(d.runCommands(t)!=0){
            ret=e.runCommands(t);
        }
        return ret;
    }
    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        d=parameters.get(0);
        e=parameters.get(1);
    }
}
