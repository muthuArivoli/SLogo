package slogo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import slogo.Operations.Operation;
import slogo.Operations.Single.ATan;
import slogo.Operations.Single.Cos;
import slogo.Operations.Single.Log;
import slogo.Operations.Single.Minus;
import slogo.Operations.Single.Not;
import slogo.Operations.Single.RandOp;
import slogo.Operations.Single.Sin;
import slogo.Operations.Single.Tan;
import slogo.Operations.Two.And;
import slogo.Operations.Two.Difference;
import slogo.Operations.Two.Equal;
import slogo.Operations.Two.Greater;
import slogo.Operations.Two.Less;
import slogo.Operations.Two.NotEqual;
import slogo.Operations.Two.Or;
import slogo.Operations.Two.Pow;
import slogo.Operations.Two.Product;
import slogo.Operations.Two.Quotient;
import slogo.Operations.Two.Remainder;
import slogo.Operations.Two.Sum;
import slogo.Variables.OpData;
import slogo.commands.AskEx;
import slogo.commands.AskWithEx;
import slogo.commands.BackEx;
import slogo.commands.ClearScreenEx;
import slogo.commands.DoTimesEx;
import slogo.commands.Executable;
import slogo.commands.ForEx;
import slogo.commands.ForwardEx;
import slogo.commands.GetPenColorEx;
import slogo.commands.GetShapeEx;
import slogo.commands.HideTurtleEx;
import slogo.commands.HomeEx;
import slogo.commands.IDEx;
import slogo.commands.IfElseEx;
import slogo.commands.IfEx;
import slogo.commands.LeftEx;
import slogo.commands.PenDownEx;
import slogo.commands.PenUpEx;
import slogo.commands.Queries.HeadingQ;
import slogo.commands.Queries.PenDownQ;
import slogo.commands.Queries.ShowingQ;
import slogo.commands.Queries.XCorQ;
import slogo.commands.Queries.YCorQ;
import slogo.commands.RepeatEx;
import slogo.commands.RightEx;
import slogo.commands.SetBackgroundEx;
import slogo.commands.SetEx;
import slogo.commands.SetHeadingEx;
import slogo.commands.SetPaletteEx;
import slogo.commands.SetPenColorEx;
import slogo.commands.SetPenSizeEx;
import slogo.commands.SetShapeEx;
import slogo.commands.SetXYEx;
import slogo.commands.ShowTurtleEx;
import slogo.commands.TellEx;
import slogo.commands.ToEx;
import slogo.commands.TowardsEx;
import slogo.commands.TurtlesEx;

public class ExecutablesGetter {
    private HashMap<String, Operation> OpMap;
    private HashMap<String,Class> classMap;

    ExecutablesGetter() {
        OpMap=new HashMap<>();
        classMap=new HashMap<>();
        setClassMap();
        setOpMap();
    }

    boolean containsKey(String s){
        return OpMap.containsKey(s)||classMap.containsKey(s);
    }

    Executable getExecutable(String s) throws InstantiationException,InvocationTargetException, IllegalAccessException{
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
                throw new NoSuchElementException();
            }
            Executable retEx=null;
            try {
                retEx= (Executable) c.newInstance();
            } catch (InstantiationException e) {
                throw new InstantiationException("ERROR: could not instantitate class properly");
            } catch (IllegalAccessException e) {
                throw new IllegalAccessException("ERROR: Illegal Access to class");
            } catch (InvocationTargetException e) {
                throw e;
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

