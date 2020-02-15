package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;

public class ForEx extends Executable {
    private Executable e;
    private CVariable amount;

    public ForEx(Executable e, CVariable amount){
        this.e=e;
    }


    @Override
    public void runCommands(Turtle t) {
        for(int i = 0;i<amount.getData();i++){
            e.runCommands(t);
        }
    }
}
