package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem3986 {
    static int N;
    static int result;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++){
                char now = input.charAt(j);
                if(stack.isEmpty() || stack.peek() != now){
                    stack.push(now);
                }
                else if(stack.peek() == now) stack.pop();
            }
            if(stack.isEmpty()) result++;
            stack.clear();
        }
        System.out.println(result);
    }
}
