package slogo.Variables;

import slogo.Turtle;
import slogo.commands.Executable;

public class CVariable extends Executable {
    private String name;
    private int data;

    public CVariable(String name){
        this.name=name;
        this.data=0;
    }

    public CVariable(String name, int data){
        this.name=name;
        this.data=data;
    }

    public int setData(int data){
        this.data=data;
        return data;
    }
    public int getData(){
        return data;
    }

    @Override
    public int runCommands(Turtle t) {
        return data;
    }
}
