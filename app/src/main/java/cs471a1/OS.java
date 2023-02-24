package cs471a1;

import java.util.Vector;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.Queue;
public class OS {
    private Prog current_program;
    private Vector<Prog> BlockedList;
    private Vector<Queue<Prog>> ReadyProgs;
    public OS(){
        current_program = null;
        BlockedList=new Vector<Prog>();
        ReadyProgs = new Vector<Queue<Prog>>();
        for(int i=0;i<5;i++){
            ReadyProgs.add(new Queue<Prog>());
        }
    }

    public String getCurrentProgram(){
        if(current_program!=null)
            return current_program.GetProgName();
        return null;
    }
    public void BlockCurrentProgram(){
        BlockedList.add(current_program);
        current_program=nextProgram();
    }
    public Prog nextProgram(){

        return null;
    }
    public void FinishProgram(){
        current_program=nextProgram();
    }
    public void AddProgram(String name, int Priority){
        Prog temp = new Prog(name, Priority);
    }
}
