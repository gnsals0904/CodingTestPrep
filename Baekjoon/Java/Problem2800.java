package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Problem2800 {
    static HashMap<Integer, Pair> map = new HashMap<>();
    static int key = 0;
    static Stack<Character> stack = new Stack<>();
    static Stack<Integer> idxStack = new Stack<>();
    static int MAX_NUM;
    static TreeSet<String> result = new TreeSet<>();
    static boolean[] canUseThis;
    static Set<Integer> cantUseIdx = new HashSet<>();
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                idxStack.push(i);
            }
            else if(input.charAt(i) == ')') {
                if(stack.peek() == '(') {
                    stack.pop();
                    map.put(key++, new Pair(idxStack.pop(), i));
                }
            }
        }
        MAX_NUM = (int) Math.pow(2, key) - 1;
        canUseThis = new boolean[key];
        recur(0, true);
        recur(0, false);
        StringBuilder sb = new StringBuilder();
        for(String r : result){
            sb.append(r).append("\n");
        }
        System.out.println(sb);
    }

    static void recur(int depth, boolean useThis){
        if(depth == key){
            saveResult();
            cantUseIdx.clear();
            return;
        }
        canUseThis[depth] = useThis;
        recur(depth+1, true);
        recur(depth+1, false);
    }

    static void saveResult(){
        boolean flag = false;
        for(int i = 0; i < key; i++){
            if(!canUseThis[i]){
                flag = true;
                Pair pair = map.get(i);
                cantUseIdx.add(pair.start);
                cantUseIdx.add(pair.end);
            }
        }
        if(!flag) return;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '(' || input.charAt(i) == ')'){
                if(cantUseIdx.contains(i)) continue;
            }
            sb.append(input.charAt(i));
        }
        result.add(sb.toString());
    }

    static class Pair{
        int start;
        int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
