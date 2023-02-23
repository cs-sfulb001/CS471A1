package cs471a1;
public class Prog {
    private String prog;
    
    public Prog(){
        prog = "new Prog";
    }
    public Prog(String name){
        prog = name;
    }
    public String GetProgName(){
        return prog;
    }
}
