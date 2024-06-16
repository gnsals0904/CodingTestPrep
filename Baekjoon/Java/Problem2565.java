package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2565 {
    static int N;
    static int[] dp;
    static Point[] electricLines;
    static int maxLen;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        electricLines = new Point[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            electricLines[i] = new Point(from, to);
        }
        Arrays.sort(electricLines);
        Arrays.fill(dp, 1);
        for(int i = 1; i < N; i++){
            int nowTo = electricLines[i].to;
            for(int j = 0; j < i; j++){
                int vsTo = electricLines[j].to;
                if(nowTo > vsTo){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        int result = N - maxLen;
        System.out.println(result);
    }

    static class Point implements Comparable<Point>{
        int from;
        int to;
        Point(int from, int to){
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Point p) {
            return Integer.compare(this.from, p.from);
        }
    }
}
