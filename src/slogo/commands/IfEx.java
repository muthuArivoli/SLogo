package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.List;

public class IfEx extends Executable {
    private Executable d;
    private Executable e;
    public IfEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        int ret=0;
        if(d.runCommands(cInterface)!=0){
            ret=e.runCommands(cInterface);
        }
        return ret;
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
        e=parameters.get(1);
    }
}
