import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11052 {
    static int N;
    static int[] cardPrices;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cardPrices = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) {
            cardPrices[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1][N+1];
        dp[0][0] = 1;
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if(j >= i){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - i] + cardPrices[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}
