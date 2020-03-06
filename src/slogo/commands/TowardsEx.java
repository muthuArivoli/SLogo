package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.List;

public class TowardsEx extends Executable {
    private Executable d1;
    private Executable d2;
    public TowardsEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.towards(d1.runCommands(cInterface), d2.runCommands(cInterface));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d1=parameters.get(0);
        d2=parameters.get(1);
    }
}
