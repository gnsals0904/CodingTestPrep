import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2624 {
    static int T, K;
    static int[] coins;
    static int[] counts;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        coins = new int[K+1];
        counts = new int[K+1];
        dp = new int[K+1][T+1];
        dp[0][0] = 1;
        StringTokenizer st;
        for(int i = 1; i < K+1; i++){
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
            counts[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= K; i++) {
            dp[i][0] = 1;
            for(int j = 1; j <= T; j++) {
                dp[i][j] = sumDP(i, j);
            }
        }
        System.out.println(dp[K][T]);
    }

    static int sumDP(int i, int j) {
        int temp = 0;
        for(int k = 0; k <= counts[i]; k++){
            int chk = j - coins[i] * k;
            if(chk < 0) break;
            temp += dp[i - 1][chk];
        }
        return temp;
    }
}
