package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2293 {
    public static void main(String[] args) throws IOException {
        // 입력
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 동전의 개수
        int N = Integer.parseInt(st.nextToken());
        // 목표 금액
        int target = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        // 동전의 종류
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        // dp 배열
        int[] dp = new int[target + 1];
        // 0 으로 초기화
        Arrays.fill(dp, 0);
        dp[0] = 1;
        // dp 배열 채우기
        for (int num = 0; num < N; num++) {
            for (int i = 1; i < target + 1; i++) {
                if (i >= coins[num]) {
                    dp[i] = dp[i] + dp[i - coins[num]];
                }
            }
        }
        System.out.println(dp[target]);
    }
}
