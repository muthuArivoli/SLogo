package slogo.commands;

import slogo.Turtle;

public class RepeatEx extends Executable {
    private Executable e;
    private Executable amount;

    public RepeatEx(Executable e, Executable amount){
        this.e=e;
        this.amount=amount;
    }


    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        for(int i = 0; i<amount.runCommands(t); i++){
            ret=e.runCommands(t);
        }
        return ret;
    }
}
