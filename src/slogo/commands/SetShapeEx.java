package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class SetShapeEx extends Executable {
    private Executable d;
    public SetShapeEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.setShape(d.runCommands(cInterface));
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}