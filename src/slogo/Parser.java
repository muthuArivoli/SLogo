package slogo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import slogo.Variables.CVariable;
import slogo.Variables.VariableHolder;
import slogo.commands.CommandEx;
import slogo.commands.Executable;
import slogo.commands.GroupEx;

public class Parser {

    private static final String PROGRAM_FINISHED_COMPILING = "Program Finished Compiling";
    private static final String CONSTANT = "constant";
    private static final String WRONG_NUMBER_FORMAT = "wrong number format: ";
    private static final String GROUP_FINISHED = "groupFinished";
    private static final String GROUP_NEVER_STARTED = "trying to end a group that never started";
    private static final String RETURNED_NULL = "reader returned null";
    private static final String GROUP_START = "groupStart";
    private static final String GROUP_NEVER_ENDS = "group never ends";
    private static final String COULDNT_READ = "reader couldn't read: ";
    private static final String ALREADY_EXISTS = "function already exists";
    private static final String NO_FUNCTION_NAME = "no function name given";
    private static final String NEVER_STARTED = "grouped information never started";
    private static final String NO_WORD_GIVEN = "no word given to the variable reader";
    private static final String NOT_A_VARIABLE = "given word is not a variable";
    private static final String FINISHED = "finished: ";
    private VariableHolder mainVariables;
    private ExecutablesGetter eg;
    private HashMap<String,Function> myFunctions;
    private LangParser myLangParser;

    public Parser(){
        mainVariables=new VariableHolder();
        eg=new ExecutablesGetter();
        myFunctions=new HashMap<>();
        myLangParser=new LangParser();
        myLangParser.addPatterns("English");
        myLangParser.addPatterns("Syntax");
    }

    Executable parse(Scanner input) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        GroupEx runnableCode =new GroupEx();
        while (input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine());
            if(line.hasNext()){
                String word = line.next();
                if(commentCheck(word)){
                    continue;
                }
                runnableCode.addExecutable(getFinishedExecutable(word, input,line, mainVariables));
            }
            while (line.hasNext()) {
                String word = line.next();
                runnableCode.addExecutable(getFinishedExecutable(word, input,line, mainVariables));
            }
        }
        System.out.println(PROGRAM_FINISHED_COMPILING + "\n\n");
        return runnableCode;
    }

    void setLanguage(LangParser lp){
        myLangParser=lp;
    }

    private ArrayList<Executable> getParameters(int amount, Scanner input, Scanner line, VariableHolder myVariables) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        ArrayList<Executable> ret = new ArrayList<>();
        for(int i = 0; i<amount;i++){
            System.out.print("param "+(i+1)+": ");
            ret.add(parseNext(input,line, myVariables));
        }
        return ret;
    }

    private Executable getFinishedExecutable(String word, Scanner input, Scanner line, VariableHolder myVariables) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println(word);
        String langWord = myLangParser.getSymbol(word);
        Executable next;
        switch(langWord)
        {
            case "Constant":
                try {
                    int data = Integer.parseInt(word);
                    return new CVariable(CONSTANT,data);
                }
                catch (NumberFormatException nfe) {
                    System.out.println(WRONG_NUMBER_FORMAT + word);
                }
            case "Variable":
                return variableReader(word, myVariables);
            case "ListStart":
                Executable group = groupParser(input, line, myVariables);
                System.out.println(GROUP_FINISHED);
                return group;
            case "ListEnd":
                System.out.println(GROUP_NEVER_STARTED);
                break;
            case "Command":
                next = funcReader(word, myVariables);
                next.setParameters(getParameters(next.getParametersAmounts(), input, line, myVariables));
                return next;
            default:
                next = commandReader(langWord, myVariables);
                if(next==null){
                    System.out.println(RETURNED_NULL);
                    return null;
                }
                if(next.isFunction()){
                    next.setParameters(toParams(createFunction(input, line)));
                }
                else {
                    next.setParameters(getParameters(next.getParametersAmounts(), input, line, myVariables));
                }
                System.out.println(FINISHED + word);
                return next;
        }
        return null;
    }

    private GroupEx groupParser(Scanner input, Scanner line, VariableHolder myVariables) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(GROUP_START);
        GroupEx group =new GroupEx();
        while (line.hasNext()) {
            String word = line.next();
            if(groupIsOver(word)){
                return group;
            }
            group.addExecutable(getFinishedExecutable(word,input,line, myVariables));
        }
        while (input.hasNextLine()) {
            line = new Scanner(input.nextLine());
            if(line.hasNext()){
                String word = line.next();
                if(commentCheck(word)){
                    continue;
                }
                if(groupIsOver(word)){
                    return group;
                }
                group.addExecutable(getFinishedExecutable(word,input,line, myVariables));
            }
            while (line.hasNext()) {
                String word = line.next();
                if(groupIsOver(word)){
                    return group;
                }
                group.addExecutable(getFinishedExecutable(word,input,line, myVariables));
            }
        }
        System.out.println(GROUP_NEVER_ENDS);
        return null;
    }

    private boolean groupIsOver(String word){
        return word.equals("]");
    }

    private Executable parseNext(Scanner input, Scanner line, VariableHolder myVariables) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (line.hasNext()) {
            String word = line.next();
            return getFinishedExecutable(word, input, line, myVariables);
        }
        while (input.hasNextLine()) {
            line = new Scanner(input.nextLine());
            if (line.hasNext()) {
                String word = line.next();
                if(commentCheck(word)){
                    continue;
                }
                return getFinishedExecutable(word, input, line, myVariables);
            }
        }

        return null;
    }

    private Executable commandReader(String word, VariableHolder myVariables) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if(eg.containsKey(word)){
            return eg.getExecutable(word);
        }
        System.out.println(COULDNT_READ +word);
        return null;
    }

    private Executable funcReader(String word, VariableHolder myVariables){
        word=word.toLowerCase();
        if(myFunctions.containsKey(word)){
            return new CommandEx(myFunctions.get(word));
        }
        System.out.println(COULDNT_READ +word);
        throw new IncorrectCommandException(COULDNT_READ +word);
        //return null;
    }

    private boolean createFunction(Scanner input, Scanner line) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        VariableHolder funcVars=new VariableHolder();
        String name;
        if(line.hasNext()){
            name = line.next().toLowerCase();
            if(eg.containsKey(name)){
                System.out.println(ALREADY_EXISTS);
                return false;
            }
        }
        else{
            System.out.println(NO_FUNCTION_NAME);
            return false;
        }
        ArrayList<String> inputVarNames;
        if(groupedInformationStarted(line)){
            inputVarNames=getFunctionVariableNames(line);
        }
        else {
            System.out.println(NEVER_STARTED);
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
        ret.add(new CVariable(CONSTANT,fC? 1: 0));
        return ret;
    }

    private ArrayList<String> getFunctionVariableNames(Scanner line){
        ArrayList<String> funcVariableNames = new ArrayList<>();
        while(line.hasNext()){
            String word = line.next().toLowerCase();
            if(groupIsOver(word)){
                break;
            }
            funcVariableNames.add(word.substring(1));
        }
        return funcVariableNames;
    }

    private boolean groupedInformationStarted(Scanner line){
        return line.hasNext()&&line.next().equals("[");
    }

    private CVariable variableReader(String word, VariableHolder myVariables){
        word=word.toLowerCase();
        if(word.equals("")){
            System.out.println(NO_WORD_GIVEN);
            return null;
        }
        if(word.charAt(0)==':'){
            return myVariables.getVariable(word.substring(1));
        }
        else {
            System.out.println(NOT_A_VARIABLE);
            return null;
        }
    }

    /**
     * Used for variable table view
     * @return Collection of CVariable values
     */
    public VariableHolder getVariableHolder() {
        return mainVariables;
    }
    private boolean commentCheck(String word){
        return (word.charAt(0) == '#');
    }
}
