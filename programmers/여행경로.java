import java.io.*;
import java.util.*;

class 여행경로 {
    static Ticket[] tickets;
    static int N;
    static String[] result;
    static boolean[] isUsed;
    public String[] solution(String[][] inputs) {
        tickets = new Ticket[inputs.length];
        N = inputs.length;
        isUsed = new boolean[N];
        result = new String[N + 1];
        for(int i = 0; i < inputs.length; i++){
            tickets[i] = new Ticket(inputs[i][0], inputs[i][1]);
        }
        Arrays.sort(tickets);
        for(int i = 0; i < N; i++){
            if(tickets[i].from.equals("ICN")){
                isUsed[i] = true;
                result[0] = "ICN";
                dfs(tickets[i], 1);
                isUsed[i] = false;
            }
        }
        return result;
    }
    
    static boolean dfs(Ticket cur, int depth){
        if(depth == N){
            result[depth] = cur.to;
            return true;
        }
    
        for(int i = 0; i < N; i++){
            if(isUsed[i]) continue;
            if(!cur.to.equals(tickets[i].from)) continue;
            result[depth] = tickets[i].from;
            isUsed[i] = true;
            if (dfs(tickets[i], depth + 1)) {
                return true;
            }
            isUsed[i] = false;
        }
        
        return false;
    }
    
    public class Ticket implements Comparable<Ticket>{
        String from;
        String to;
        
        public Ticket(String from, String to){
            this.from = from;
            this.to = to;
        }
        
        @Override
        public int compareTo(Ticket o) {
            int fromComparison = this.from.compareTo(o.from);
            if (fromComparison != 0) {
                return fromComparison;
            }
            return this.to.compareTo(o.to);
        }

        @Override
        public String toString(){
            return "from : " + this.from + " to : " + this.to;
        }
    }
}
