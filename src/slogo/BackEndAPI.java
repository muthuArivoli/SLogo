package slogo;

import java.util.Collection;
import slogo.Variables.CVariable;
import slogo.Variables.VariableHolder;
import slogo.commands.Executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public class BackEndAPI {
    private Parser myParser;
    private ArrayList<Executable> myPrograms;
    public BackEndAPI(){
        myPrograms=new ArrayList<>();
        myParser=new Parser();
    }
    private Executable build(String s) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner sc = new Scanner(s);
        Executable e = myParser.parse(sc);
        return e;
    }
    public void buildAndRun(String s, FrontEndAPI fAPI) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Executable e = build(s);
        e.runCommands(fAPI);
    }
    public void setLanguage(String language){
        LangParser lp = new LangParser();
        lp.addPatterns(language);
        lp.addPatterns("Syntax");
        myParser.setLanguage(lp);
    }
    public void runFile(File f, FrontEndAPI fAPI) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner sc = null;

        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("the file was not found");
        }
        Executable e = myParser.parse(sc);
        e.runCommands(fAPI);
    }
    public VariableHolder getVariables() {
        return myParser.getVariableHolder();
    }
}
