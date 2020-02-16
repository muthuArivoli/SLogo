package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;

import java.util.ArrayList;

public class ForEx extends VExecutable {
    private Executable start;
    private Executable end;
    private Executable increment;
    private Executable e;
    public ForEx(){
        setParametersAmounts(4);
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        for(int i = start.runCommands(t); i<end.runCommands(t); i+=increment.runCommands(t)){
            myVariable.setData(i);
            ret=e.runCommands(t);
        }
        return ret;
    }

    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        start=parameters.get(0);
        end=parameters.get(1);
        increment=parameters.get(2);
        e=parameters.get(3);
    }
}
