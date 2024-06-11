package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem17298 {
    static int N;
    static Stack<Point> stack = new Stack<>();
    static int[] result;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());
            Point point = new Point(value, i);
            if(!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek().v < point.v){
                    Point p = stack.pop();
                    result[p.idx] = point.v;
                }
            }
            stack.add(point);
        }
        StringBuilder sb = new StringBuilder();
        for(int num : result){
            if(num == 0) sb.append(-1).append(" ");
            else sb.append(num).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    static class Point{
        int v;
        int idx;
        Point(int v, int idx){
            this.v = v;
            this.idx = idx;
        }
    }
}
