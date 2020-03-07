package slogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import slogo.Variables.VariableHolder;
import slogo.commands.Executable;

public class BackEndAPI {
    private static final String FILE_NOT_FOUND_MESSAGE = "the file was not found";
    private Parser myParser;

    BackEndAPI(){
        myParser=new Parser();
    }
    private Executable build(String s) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner sc = new Scanner(s);
        Executable e = myParser.parse(sc);
        return e;
    }
    void buildAndRun(String s, FrontEndAPI fAPI) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Executable e = build(s);
        e.runCommands(fAPI);
    }
    void setLanguage(String language){
        LangParser lp = new LangParser();
        lp.addPatterns(language);
        lp.addPatterns("Syntax");
        myParser.setLanguage(lp);
    }
    void runFile(File f, FrontEndAPI fAPI) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner sc = null;

        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND_MESSAGE);
        }
        Executable e = myParser.parse(sc);
        e.runCommands(fAPI);
    }
    public VariableHolder getVariables() {
        return myParser.getVariableHolder();
    }
}
