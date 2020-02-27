package slogo.commands;

import slogo.Turtle;

import java.util.List;

public class DoTimesEx extends GExecutable {
    private Executable limit;
    private Executable e;


    public DoTimesEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        for(int i = 0; i<limit.runCommands(t); i++){
            myVariable.setData(i);
            ret=e.runCommands(t);
        }
        return ret;
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        limit=parameters.get(0);
        e=parameters.get(1);
    }
}
