package slogo.ExecutableClassGetters;

import slogo.Operations.Operation;
import slogo.Operations.Single.*;
import slogo.Operations.Two.*;
import slogo.Variables.OpData;
import slogo.commands.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ExecutablesGetter {
    private HashMap<String, Operation> OpMap;
    private HashMap<String,Class> classMap;

    public ExecutablesGetter() {
        OpMap=new HashMap<>();
        classMap=new HashMap<>();
        setClassMap();
        setOpMap();
    }

    public boolean containsKey(String s){
        s=s.toLowerCase();
        return OpMap.containsKey(s)||classMap.containsKey(s);
    }

    public Executable getExecutable(String s){
        s=s.toLowerCase();
        if(!containsKey(s)){
            System.out.println("given string is not a key");
        }
        if(OpMap.containsKey(s)) {
            return new OpData(OpMap.get(s));
        }
        else{
            Class basicClass = classMap.get(s);
            Constructor c = null;
            try {
                c= basicClass.getConstructor(new Class[]{});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Executable retEx=null;
            try {
                retEx= (Executable) c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return retEx;
        }

    }

    private void setClassMap() {
        classMap.put("make", SetEx.class);
        classMap.put("set", SetEx.class);
        classMap.put("dotimes", DoTimesEx.class);
        classMap.put("for", ForEx.class);
        classMap.put("forward", ForwardEx.class);
        classMap.put("fd", ForwardEx.class);
        classMap.put("back", BackEx.class);
        classMap.put("bk", BackEx.class);
        classMap.put("left", LeftEx.class);
        classMap.put("lt", LeftEx.class);
        classMap.put("right", RightEx.class);
        classMap.put("rt", RightEx.class);
        classMap.put("setheading", SetHeadingEx.class);
        classMap.put("seth", SetHeadingEx.class);
        classMap.put("towards", TowardsEx.class);
        classMap.put("setxy", SetXYEx.class);
        classMap.put("goto", SetXYEx.class);
        classMap.put("pendown", PenDownEx.class);
        classMap.put("pd", PenDownEx.class);
        classMap.put("penup", PenUpEx.class);
        classMap.put("pu", PenUpEx.class);
        classMap.put("showturtle", ShowTurtleEx.class);
        classMap.put("st", ShowTurtleEx.class);
        classMap.put("hideturtle", HideTurtleEx.class);
        classMap.put("ht", HideTurtleEx.class);
        classMap.put("home", HomeEx.class);
        classMap.put("repeat", RepeatEx.class);
        classMap.put("if", IfEx.class);
        classMap.put("ifelse", IfElseEx.class);
    }
    private void setOpMap(){
        OpMap.put("sum",new Sum());
        OpMap.put("difference",new Difference());
        OpMap.put("product",new Product());
        OpMap.put("quotient",new Quotient());
        OpMap.put("remainder",new Remainder());
        OpMap.put("minus",new Minus());
        OpMap.put("random",new RandOp());
        OpMap.put("sin",new Sin());
        OpMap.put("cos",new Cos());
        OpMap.put("tan",new Tan());
        OpMap.put("atan",new ATan());
        OpMap.put("log",new Log());
        OpMap.put("pow",new Pow());
        OpMap.put("less?",new Less());
        OpMap.put("lessp",new Less());
        OpMap.put("greater?",new Greater());
        OpMap.put("greaterp",new Greater());
        OpMap.put("equal?",new Equal());
        OpMap.put("equalp",new Equal());
        OpMap.put("notequal?",new NotEqual());
        OpMap.put("notequalp",new NotEqual());
        OpMap.put("and",new And());
        OpMap.put("or",new Or());
        OpMap.put("not",new Not());
    }
}

