package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem3015 {
    static int N;
    static long result;
    static Stack<Person> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(br.readLine());
            while(!stack.isEmpty() && stack.peek().length < now){
                result += stack.pop().count;
            }
            if(stack.isEmpty()){
                stack.add(new Person(now, 1));
                continue;
            }
            if(stack.peek().length == now){
                Person p = stack.pop();
                result += p.count;
                if(!stack.isEmpty()) result++;
                p.count++;
                stack.push(p);
            }
            else{
                stack.push(new Person(now, 1));
                result++;
            }
        }
        System.out.println(result);
    }

    static class Person{
        int length;
        int count;

        Person(int length, int count){
            this.length = length;
            this.count = count;
        }
    }
}
