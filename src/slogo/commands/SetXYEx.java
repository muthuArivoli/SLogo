package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class SetXYEx extends Executable {
    private Executable d1;
    private Executable d2;
    public SetXYEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.setXY(d1.runCommands(cInterface), d2.runCommands(cInterface));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d1=parameters.get(0);
        d2=parameters.get(1);
    }
}
