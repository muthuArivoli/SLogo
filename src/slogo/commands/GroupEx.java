package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.ArrayList;

public class GroupEx extends Executable {

    private ArrayList<Executable> eList;

    public GroupEx(){
        eList=new ArrayList<>();
    }

    public void addExecutable(Executable e){
        eList.add(e);
    }


    @Override
    public int runCommands(CommandInterface cInterface) {
        int ret=0;
        for(Executable e:eList){
            ret = e.runCommands(cInterface);
        }
        return ret;
    }

    public ArrayList<Executable> getGroupMembers(){
        return eList;
    }
}
