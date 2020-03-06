package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.List;

public class SetBackgroundEx extends Executable {
    private Executable d;
    public SetBackgroundEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.setBackground(d.runCommands(cInterface));
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}