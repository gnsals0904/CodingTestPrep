package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem1918 {
    static String input;
    static int inputLen;
    static StringBuilder result = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        input = br.readLine();
        inputLen = input.length();
        for(int i = 0; i < inputLen; i++){
            calc(input.charAt(i));
        }
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        System.out.println(result);
    }

    // Alpha => true
    // quote => false
    static boolean isAlpha(char c){
        return c != '*' && c != '/' && c != '+' && c != '-' && c != '(' && c != ')';
    }

    static void calc(char c){
        if(isAlpha(c)) result.append(c);
        else{
            if(c == '+' || c == '-'){
                if(stack.isEmpty()){
                    stack.push(c);
                }
                else if(stack.peek() == '+' || stack.peek() == '-'){
                    result.append(stack.pop());
                    stack.push(c);
                }
                else if(stack.peek() == '*' || stack.peek() == '/'){
                    while (!stack.isEmpty() && stack.peek() != '('){
                        result.append(stack.pop());
                    }
                    stack.push(c);
                }
                else if(stack.peek() == '('){
                    stack.push(c);
                }
            }
            else if(c == '*' || c == '/'){
                if(stack.isEmpty()){
                    stack.push(c);
                }
                else if(stack.peek() == '+' || stack.peek() == '-'){
                    stack.push(c);
                }
                else if(stack.peek() == '*' || stack.peek() == '/'){
                    result.append(stack.pop());
                    stack.push(c);
                }
                else if(stack.peek() == '('){
                    stack.push(c);
                }
            }
            else if(c == '(') {
                stack.push(c);
            }
            else {
                while (!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                if (stack.peek() == '(') stack.pop();
            }
        }
    }
}
