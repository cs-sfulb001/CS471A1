package cs471a1;

import cs471a1.Prog;
import java.util.Vector
;
public class OS {
    private Prog current_program;
    private Vector<Prog> BlockedList;
    public OS(){
        current_program = null;
        BlockedList=new Vector<Prog>();
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
}
