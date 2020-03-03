package slogo.commands;

import slogo.Turtle;

import java.util.List;

public class RepeatEx extends Executable {
    private Executable amount;
    private Executable e;


    public RepeatEx(){
        setParametersAmounts(2);
    }


    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        for(int i = 0; i<amount.runCommands(t); i++){
            ret=e.runCommands(t);
        }
        return ret;
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        amount=parameters.get(0);
        e=parameters.get(1);
    }
}
