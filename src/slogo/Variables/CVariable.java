package slogo.Variables;

import slogo.commands.Executable;
import slogo.configuration.CommandInterface;

public class CVariable extends Executable {
    private String name;
    private int data;
    private String dataTable;

    public CVariable(String name){
        this.name=name;
        this.data=0;
        this.dataTable = Integer.toString(data);
    }

    public CVariable(String name, int data){
        this.name=name;
        this.data=data;
        this.dataTable = Integer.toString(data);
    }

    public int setData(int data){
        this.data=data;
        this.dataTable = Integer.toString(data);
        return data;
    }
    public int getData(){
        return data;
    }
    public String getName() { return name; }
    public String getDataTable() {return dataTable; }

    @Override
    public int runCommands(CommandInterface cInterface) {
        return data;
    }
}
