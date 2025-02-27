import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2294 {
    static int N, K;
    static int[] coins;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N][K+1];
        coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], 10001);
            dp[i][0] = 0;
        }
        for(int i = 1; i < K+1; i++){
            if(i % coins[0] == 0) dp[0][i] = i/coins[0];
        }
        for(int i = 1; i < N; i++){
            for(int j = 1; j < K+1; j++){
                if (j >= coins[i]) dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[N-1][K] == 10001) System.out.println(-1);
        else System.out.println(dp[N-1][K]);
    }
}
