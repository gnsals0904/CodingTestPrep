package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem18353 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		int[] n_list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			n_list[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		int max_num = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(n_list[i] < n_list[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max_num = Math.max(dp[i], max_num);
		}
		if(N == 1) {
			System.out.println(0);
			return;
		}
		System.out.println(N - max_num);
	}
}
