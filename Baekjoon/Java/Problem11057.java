import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem11057 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) - 1;
        dp = new int[N + 1][10];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i <= N; i++){
            dp[i][0] = 1;
            for(int j = 1; j < 10; j++){
                dp[i][j] = (dp[i - 1][j] % 10007 + dp[i][j - 1] % 10007) % 10007;
            }
        }
        int result = 0;
        for(int i = 0; i < 10; i++) {
            result += dp[N][i];
            result %= 10007;
        }
        System.out.println(result);
    }
}
