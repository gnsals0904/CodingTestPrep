package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2631 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		int[] numlist = new int[N];
		for(int i = 0; i < N; i++) {
			numlist[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				// 내가 더 크면
				if(numlist[i] > numlist[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max_len = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			max_len = Math.max(max_len, dp[i]);
		}
		System.out.println(N - max_len);
	}
}
