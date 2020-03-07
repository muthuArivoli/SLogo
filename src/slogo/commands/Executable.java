package slogo.commands;

import javafx.scene.Group;
import slogo.Variables.CVariable;
import slogo.XMLSaveLoadAndExceptions.ParserException;
import slogo.configuration.CommandInterface;

import java.util.List;

public abstract class Executable {
    protected int parametersAmounts;

    public abstract int runCommands(CommandInterface cInterface);

    public int getParametersAmounts(){
        return parametersAmounts;
    }

    public void setParameters(List<Executable> parameters){
        if(this.parametersAmounts!=parameters.size()){
            System.out.println("wrong amount of parameters");
        }
        setMyParameters(parameters);
    }

    protected void setMyParameters(List<Executable> parameters){
        return;
    }

    public boolean isFunction(){
        return false;
    }

    protected void setParametersAmounts(int amount){
        parametersAmounts=amount;
    }

    protected CVariable getVariableFromExecutable(Executable e){
        CVariable retVar = null;
        try {
            retVar = (CVariable) e;
        }
        catch (ClassCastException cce){
            System.out.println("Executable not a Variable");
        }
        return retVar;
    }

    protected GroupEx getGroupFromExecutable(Executable e){
        GroupEx retGroup = null;
        try {
            retGroup = (GroupEx) e;
        }
        catch (ClassCastException cce){
            System.out.println("Executable not a Group");
        }
        return retGroup;
    }

}
