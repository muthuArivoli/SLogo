package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class RepeatEx extends Executable {
    private Executable e;
    private Executable amount;

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
    public void setMyParameters(ArrayList<Executable> parameters) {
        e=parameters.get(0);
        amount=parameters.get(1);
    }
}
