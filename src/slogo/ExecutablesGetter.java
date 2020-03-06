package slogo;

import slogo.Operations.Operation;
import slogo.Operations.Single.*;
import slogo.Operations.Two.*;
import slogo.Variables.OpData;
import slogo.commands.*;
import slogo.commands.Queries.*;
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
        return OpMap.containsKey(s)||classMap.containsKey(s);
    }

    public Executable getExecutable(String s){
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
        classMap.put("MakeVariable", SetEx.class);
        classMap.put("DoTimes", DoTimesEx.class);
        classMap.put("For", ForEx.class);
        classMap.put("Forward", ForwardEx.class);
        classMap.put("Backward", BackEx.class);
        classMap.put("Left", LeftEx.class);
        classMap.put("Right", RightEx.class);
        classMap.put("SetHeading", SetHeadingEx.class);
        classMap.put("SetTowards", TowardsEx.class);
        classMap.put("SetPosition", SetXYEx.class);
        classMap.put("PenDown", PenDownEx.class);
        classMap.put("PenUp", PenUpEx.class);
        classMap.put("ShowTurtle", ShowTurtleEx.class);
        classMap.put("HideTurtle", HideTurtleEx.class);
        classMap.put("Home", HomeEx.class);
        classMap.put("Repeat", RepeatEx.class);
        classMap.put("If", IfEx.class);
        classMap.put("IfElse", IfElseEx.class);
        classMap.put("XCoordinate", XCorQ.class);
        classMap.put("YCoordinate", YCorQ.class);
        classMap.put("Heading", HeadingQ.class);
        classMap.put("IsPenDown", PenDownQ.class);
        classMap.put("IsShowing", ShowingQ.class);
        classMap.put("MakeUserInstruction", ToEx.class);
        classMap.put("ClearScreen", ClearScreenEx.class);
        classMap.put("SetBackground", SetBackgroundEx.class);
        classMap.put("SetPenColor", SetPenColorEx.class);
        classMap.put("SetPenSize", SetPenSizeEx.class);
        classMap.put("SetShape", SetShapeEx.class);
        classMap.put("SetPalette", SetPaletteEx.class);
        classMap.put("GetPenColor", GetPenColorEx.class);
        classMap.put("GetShape", GetShapeEx.class);
        classMap.put("ID", IDEx.class);
        classMap.put("Turtles", TurtlesEx.class);
        classMap.put("Tell", TellEx.class);
        classMap.put("Ask", AskEx.class);
        classMap.put("AskWith", AskWithEx.class);
    }
    private void setOpMap(){
        OpMap.put("Sum",new Sum());
        OpMap.put("Difference",new Difference());
        OpMap.put("Product",new Product());
        OpMap.put("Quotient",new Quotient());
        OpMap.put("Remainder",new Remainder());
        OpMap.put("Minus",new Minus());
        OpMap.put("Random",new RandOp());
        OpMap.put("Sine",new Sin());
        OpMap.put("Cosine",new Cos());
        OpMap.put("Tangent",new Tan());
        OpMap.put("ArcTangent",new ATan());
        OpMap.put("NaturalLog",new Log());
        OpMap.put("Power",new Pow());
        OpMap.put("LessThan",new Less());
        OpMap.put("GreaterThan",new Greater());
        OpMap.put("Equal",new Equal());
        OpMap.put("NotEqual",new NotEqual());
        OpMap.put("And",new And());
        OpMap.put("Or",new Or());
        OpMap.put("Not",new Not());
    }
}

