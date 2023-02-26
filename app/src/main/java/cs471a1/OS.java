package cs471a1;

import java.util.PriorityQueue;
import java.util.Vector;
public class OS {
    private Prog current_program;
    private Vector<Prog> BlockedList;
    private Vector<Vector<Prog>> ReadyProgs;
    public OS(){
        current_program = null;
        BlockedList=new Vector<Prog>();
        ReadyProgs = new Vector<Vector<Prog>>();
        for(int i=0;i<5;i++){
            ReadyProgs.add(new Vector<Prog>());
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
        for(int i=ReadyProgs.size()-1;i>0;i--){
            if(ReadyProgs.elementAt(i).size()>0){
                Prog temp = ReadyProgs.elementAt(i).elementAt(0);
                ReadyProgs.elementAt(i).remove(0);
                return temp;
            }
        }
        return null;
    }
    public void FinishProgram(){
        current_program=nextProgram();
    }
    public void AddProgram(String name, int Priority){
        Prog temp = new Prog(name, Priority);
        ReadyProgs.elementAt(Priority).add(temp);
        if(current_program==null)
        {
            FinishProgram();
        }
    }
    public void Unblock(int index){
        Prog program = BlockedList.elementAt(index);
        int priority = program.GetProgPriority();
        BlockedList.remove(index);
        ReadyProgs.elementAt(priority).add(program);
    }
    public String BlocklistString(){
        String temp="";
        for(int i=0;i<BlockedList.size();i++){
            temp+=Integer.toString(i)+"."+BlockedList.elementAt(i).GetProgName()+"\n";
        }
        return temp;
    }
    public String priortyQueueString(int row){
        String temp = "";
        temp+="Priority "+Integer.toString(row)+" | ";
        for(int j=0;j<ReadyProgs.elementAt(row).size();j++){
            temp+=ReadyProgs.elementAt(row).elementAt(j).GetProgName()+" | ";
        }
        temp+="\n";
        return temp;
    }
}
