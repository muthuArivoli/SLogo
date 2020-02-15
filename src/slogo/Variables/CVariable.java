package slogo.Variables;

public class CVariable extends Data {
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
    public int getData(){
        return data;
    }
    public int setData(int data){
        this.data=data;
        return data;
    }
    public String getName(){
        return name;
    }
}
