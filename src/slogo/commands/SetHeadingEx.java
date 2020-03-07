package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class SetHeadingEx extends Executable {
    private Executable d;
    public SetHeadingEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.setHeading(d.runCommands(cInterface));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}
