package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class IfElseEx extends Executable {
    private Executable d;
    private Executable trueCommands;
    private Executable falseCommands;
    public IfElseEx(){
        setParametersAmounts(3);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        int ret=0;
        if(d.runCommands(cInterface)!=0){
           ret=trueCommands.runCommands(cInterface);
        }
        else{
            ret=falseCommands.runCommands(cInterface);
        }
        return ret;
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
        trueCommands=parameters.get(1);
        falseCommands=parameters.get(2);
    }
}
