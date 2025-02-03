package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem10799 {
    static char[] input;
    static Stack<Character> stack = new Stack<>();
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        input = temp.toCharArray();
        char prev = ' ';
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '(') stack.push(input[i]);
            else if(input[i] == ')' && prev == '(') {
                stack.pop();
                result += stack.size();
            } else if(input[i] == ')' && prev == ')'){
                result += 1;
                stack.pop();
            }
            prev = input[i];
        }
        System.out.println(result);
    }
}
