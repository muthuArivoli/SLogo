package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.List;

public class SetPaletteEx extends Executable {
    private Executable index;
    private Executable r;
    private Executable g;
    private Executable b;
    public SetPaletteEx(){
        setParametersAmounts(4);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.setPallet(index.runCommands(cInterface), r.runCommands(cInterface),g.runCommands(cInterface), b.runCommands(cInterface));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        index=parameters.get(0);
        r=parameters.get(1);
        g=parameters.get(2);
        b=parameters.get(3);
    }
}
