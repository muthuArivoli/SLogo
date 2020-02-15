package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class RepeatEx extends Executable {
    private Executable e;
    private Data amount;

    public RepeatEx(Executable e, Data amount){
        this.e=e;
        this.amount=amount;
    }


    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        for(int i = 0;i<amount.getData();i++){
            ret=e.runCommands(t);
        }
        return ret;
    }
}
