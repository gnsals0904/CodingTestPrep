package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem14719 {
    static int H, W;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int maxValue = Integer.parseInt(st.nextToken());
        stack.add(maxValue);
        int result = 0;
        for(int i = 1; i < W; i++){
            int nowValue = Integer.parseInt(st.nextToken());
            if(maxValue <= nowValue){
                while (!stack.isEmpty()){
                    result += maxValue - stack.pop();
                }
                maxValue = nowValue;
                stack.add(maxValue);
            }
            else{
                stack.add(nowValue);
            }
        }
        int v = -1;
        if(!stack.isEmpty()) {
            v = stack.peek();
        }
        while (!stack.isEmpty()){
            int now = stack.pop();
            if(v > now){
                result += v - now;
            }
            else{
                v = now;
            }
        }
        System.out.println(result);
    }
}
