package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class Problem9935 {
    static char[] input;
    static char[] bomb;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        bomb = br.readLine().toCharArray();
        for(int i = 0; i < input.length; i++){
            char now = input[i];
            stack.push(now);
            if(stack.size() >= bomb.length && bomb[bomb.length-1] == now){
                if(isCorrect()){
                    int bombSize = bomb.length;
                    while(bombSize-- > 0){
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        }
        else{
            char[] result = new char[stack.size()];
            while(!stack.isEmpty()){
                result[stack.size()-1] = stack.pop();
            }
            System.out.println(result);
        }
    }

    static boolean isCorrect(){
        int bombSize = bomb.length;
        for(int i = stack.size() - 1; i >= stack.size() - bomb.length ; i--){
            if(stack.get(i) != bomb[--bombSize]){
                return false;
            }
        }
        return true;
    }
}
