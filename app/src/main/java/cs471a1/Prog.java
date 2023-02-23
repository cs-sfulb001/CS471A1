package cs471a1;
public class Prog {
    private String prog;
    private int Priority;
    public Prog(){
        prog = "new Prog";
        Priority = 0;
    }
    public Prog(String name){
        prog = name;
        Priority = 0;
    }
    public Prog(String name, int priority){
        prog = name;
        Priority = priority;
    }
    public String GetProgName(){
        return prog;
    }
    public int GetProgPriority(){
        return Priority;
    }
}
