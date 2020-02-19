package slogo.Variables;

import java.util.HashMap;

public class VariableHolder {
    HashMap<String, CVariable> myVariables;

    public VariableHolder(){
        myVariables=new HashMap<>();
    }

    public CVariable makeVariable(String name, int data){
        name=name.toLowerCase();
        myVariables.put(name,new CVariable(name, data));
        return myVariables.get(name);
    }

    public CVariable getVariable(String name){
        name=name.toLowerCase();
        if(!myVariables.containsKey(name)){
            myVariables.put(name, new CVariable(name));
        }
        return myVariables.get(name);
    }
}
