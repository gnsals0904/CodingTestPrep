import java.util.Scanner;

public class Problem11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        for(int i = 4; i < n + 1; i++){
            dp[i] = dp[i - 1] + (2 * dp[i - 2]) % 10007;
            dp[i] = dp[i] % 10007;
        }
        System.out.println(dp[n]);
    }
}
