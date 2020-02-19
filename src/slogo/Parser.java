package slogo;

import slogo.Variables.CVariable;
import slogo.Variables.VariableHolder;
import slogo.commands.CommandEx;
import slogo.commands.Executable;
import slogo.commands.GroupEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {

    private VariableHolder mainVariables;
    private ExecutablesGetter eg;
    private HashMap<String,Function> myFunctions;

    public Parser(){
        mainVariables=new VariableHolder();
        eg=new ExecutablesGetter();
        myFunctions=new HashMap<>();
    }

    public Executable parse(Scanner input){
        GroupEx runnableCode =new GroupEx();
        while (input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine());
            if(line.hasNext()){
                String word = line.next();
                if(commentCheck(word))continue;
                runnableCode.addExecutable(getFinishedExecutable(word, input,line, mainVariables));
            }
            while (line.hasNext()) {
                String word = line.next();
                runnableCode.addExecutable(getFinishedExecutable(word, input,line, mainVariables));
            }
        }
        System.out.println("Program Finished Compiling\n\n");
        return runnableCode;
    }

    private ArrayList<Executable> getParameters(int amount, Scanner input, Scanner line, VariableHolder myVariables){
        ArrayList<Executable> ret = new ArrayList<>();
        for(int i = 0; i<amount;i++){
            System.out.print("param "+(i+1)+": ");
            ret.add(parseNext(input,line, myVariables));
        }
        return ret;
    }

    private Executable getFinishedExecutable(String word, Scanner input, Scanner line, VariableHolder myVariables){
        System.out.println(word);
        try {
            int data = Integer.parseInt(word);
            return new CVariable("constant",data);
        }
        catch (NumberFormatException nfe) {
            if (word.equals("[")) {
                Executable group = groupParser(input, line, myVariables);
                System.out.println("groupFinished");
                return group;
            }

            if (word.equals("]")) {
                System.out.println("trying to end a group that never started");
            }

            Executable next = reader(word, myVariables);
            if(next==null){
                System.out.println("reader returned null");
                return null;
            }

            if(next.isFunction()){
                next.setParameters(toParams(createFunction(input, line)));
            }
            else if(next.needsGroupedInputs()){
                if(groupedInformationStarted(line)) {
                    setVariableIfNeeded(next,line,myVariables);
                    next.setParameters(getGroupedParameters(next.getParametersAmounts(), input, line, myVariables));
                }
            }
            else {
                setVariableIfNeeded(next,line,myVariables);
                next.setParameters(getParameters(next.getParametersAmounts(), input, line, myVariables));
            }
            System.out.println("finished: "+word);
            return next;
        }
    }

    private GroupEx groupParser(Scanner input, Scanner line, VariableHolder myVariables){
        System.out.println("groupStart");
        GroupEx group =new GroupEx();
        while (line.hasNext()) {
            String word = line.next();
            if(groupIsOver(word))return group;
            group.addExecutable(getFinishedExecutable(word,input,line, myVariables));
        }
        while (input.hasNextLine()) {
            line = new Scanner(input.nextLine());
            if(line.hasNext()){
                String word = line.next();
                if(commentCheck(word))continue;
                if(groupIsOver(word))return group;
                group.addExecutable(getFinishedExecutable(word,input,line, myVariables));
            }
            while (line.hasNext()) {
                String word = line.next();
                if(groupIsOver(word))return group;
                group.addExecutable(getFinishedExecutable(word,input,line, myVariables));
            }
        }
        System.out.println("group never ends");
        return null;
    }

    private boolean groupIsOver(String word){
        return word.equals("]");
    }

    private Executable parseNext(Scanner input, Scanner line, VariableHolder myVariables){
        if (line.hasNext()) {
            String word = line.next();
            return getFinishedExecutable(word, input, line, myVariables);
        }
        while (input.hasNextLine()) {
            line = new Scanner(input.nextLine());
            if (line.hasNext()) {
                String word = line.next();
                if(commentCheck(word))continue;
                return getFinishedExecutable(word, input, line, myVariables);
            }
        }

        return null;
    }

    private Executable reader(String word, VariableHolder myVariables){
        word=word.toLowerCase();
        if(word.equals("")){
            System.out.println("no word given to the reader");
            return null;
        }
        if(word.charAt(0)==':'){
            return myVariables.getVariable(word.substring(1));
        }
        if(eg.containsKey(word)){
            return eg.getExecutable(word);
        }
        if(myFunctions.containsKey(word)){
            return new CommandEx(myFunctions.get(word));
        }
        System.out.println("reader couldn't read: "+word);
        return null;
    }

    private boolean createFunction(Scanner input, Scanner line){
        String name;
        ArrayList<String> inputVarNames;
        VariableHolder funcVars=new VariableHolder();
        if(line.hasNext()){
            name = line.next().toLowerCase();
            if(eg.containsKey(name)){
                System.out.println("function already exists");
                return false;
            }
        }
        else{
            System.out.println("no function name given");
            return false;
        }
        if(groupedInformationStarted(line)){
            inputVarNames=getFunctionVariableNames(line);
        }
        else {
            System.out.println("grouped information never started");
            return false;
        }
        for(String s:inputVarNames){
            funcVars.getVariable(s);
        }
        Executable e = parseNext(input,line,funcVars);
        Function f =  new Function(funcVars,inputVarNames,e);
        System.out.println("function \""+name+"\" created");
        myFunctions.put(name, f);
        return true;
    }

    private ArrayList<Executable> toParams(boolean fC){
        ArrayList<Executable> ret = new ArrayList<>();
        ret.add(new CVariable("constant",fC? 1: 0));
        return ret;
    }

    private ArrayList<String> getFunctionVariableNames(Scanner line){
        ArrayList<String> funcVariableNames = new ArrayList<>();
        while(line.hasNext()){
            String word = line.next().toLowerCase();
            if(groupIsOver(word))break;
            funcVariableNames.add(word.substring(1));
        }
        return funcVariableNames;
    }

    private ArrayList<Executable> getGroupedParameters(int amount, Scanner input, Scanner line, VariableHolder myVariables){
        ArrayList<Executable> ret = new ArrayList<>();
        int count=0;
        while(line.hasNext()){
            String word = line.next();
            if(groupIsOver(word))break;
            ret.add(getFinishedExecutable(word,input,line, myVariables));
            count++;
        }
        ret.addAll(getParameters(amount-count,input,line,myVariables));
        return ret;
    }

    private boolean groupedInformationStarted(Scanner line){
        return line.hasNext()&&line.next().equals("[");
    }

    private CVariable nextVariableInLine(Scanner line, VariableHolder myVariables){
        String word = line.next();
        return variableReader(word, myVariables);
    }

    private CVariable variableReader(String word, VariableHolder myVariables){
        word=word.toLowerCase();
        if(word.equals("")){
            System.out.println("no word given to the variable reader");
            return null;
        }
        if(word.charAt(0)==':'){
            System.out.println(word);
            return myVariables.getVariable(word.substring(1));
        }
        else {
            System.out.println("given word is not a variable");
            return null;
        }
    }

    private void setVariableIfNeeded(Executable e, Scanner line, VariableHolder myVariables){
        if (e.needsVariable()) {
            e.setVariable(nextVariableInLine(line, myVariables));
        }
    }

    private boolean commentCheck(String word){
        return (word.charAt(0) == '#');
    }
}