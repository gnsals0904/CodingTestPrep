package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1890 {
    static int N;
    static int[][] graph;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new long[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == N - 1 && j == N - 1) continue;
                if(dp[i][j] != 0) jump(i, j, graph[i][j]);
            }
        }
        System.out.println(dp[N - 1][N - 1]);

    }

    static void jump(int x, int y, int d){
        if (x + d < N) {
            dp[x + d][y] += dp[x][y];
        }
        if (y + d < N) {
            dp[x][y + d] += dp[x][y];
        }
    }
    
}
