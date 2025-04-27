import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15483 {
    static String A, B;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        dp = new int[A.length() + 1][B.length() + 1];
        for(int i = 0; i < A.length() + 1; i++)
            dp[i][0] = i;
        for(int j = 0; j < B.length() + 1; j++)
            dp[0][j] = j;

        for(int i = 1; i < A.length() + 1; i++) {
            for(int j = 1; j < B.length() + 1; j++) {
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    int temp = Math.min(dp[i-1][j], dp[i][j-1]);
                    temp = Math.min(temp, dp[i-1][j-1]);
                    dp[i][j] = temp + 1;
                }
            }
        }

        System.out.println(dp[A.length()][B.length()]);
    }
}
