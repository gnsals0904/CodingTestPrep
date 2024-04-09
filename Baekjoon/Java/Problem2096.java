package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2096 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		// 0 => min 1 => max
//		int[][][] dp = new int[2][N][3];
		int[][] dp = new int[2][3];
		int[][] last_dp = new int[2][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		last_dp[0][0] = Integer.parseInt(st.nextToken());
		last_dp[1][0] = last_dp[0][0];
		last_dp[0][1] = Integer.parseInt(st.nextToken());
		last_dp[1][1] = last_dp[0][1];
		last_dp[0][2] = Integer.parseInt(st.nextToken());
		last_dp[1][2] = last_dp[0][2];
		if(N == 1) {
			int temp = Math.min(last_dp[0][0], last_dp[0][1]);
			int min_result = Math.min(temp, last_dp[0][2]);
			
			temp = Math.max(last_dp[1][0], last_dp[1][1]);
			int max_result = Math.max(temp, last_dp[1][2]);
			System.out.println(max_result + " " + min_result);
			return;
		}
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 1열
			int nx1 = Integer.parseInt(st.nextToken());
			// min 값 챙기기
			dp[0][0] = Math.min(last_dp[0][0] + nx1, last_dp[0][1] + nx1);
			// max 값 챙기기
			dp[1][0] = Math.max(last_dp[1][0] + nx1, last_dp[1][1] + nx1);
			
			// 2열
			int nx2 = Integer.parseInt(st.nextToken());
			// min 값 챙기기
			int temp = Math.min(last_dp[0][0] + nx2, last_dp[0][1] + nx2);
			dp[0][1] = Math.min(temp, last_dp[0][2] + nx2);
			// max 값 챙기기
			temp = Math.max(last_dp[1][0] + nx2, last_dp[1][1] + nx2);
			dp[1][1] = Math.max(temp, last_dp[1][2] + nx2);
			
			// 3열
			int nx3 = Integer.parseInt(st.nextToken());
			// min 값 챙기기
			dp[0][2] = Math.min(last_dp[0][1] + nx3, last_dp[0][2] + nx3);
			// max 값 챙기기
			dp[1][2] = Math.max(last_dp[1][1] + nx3, last_dp[1][2] + nx3);
//			for(int j = 0; j < 2; j++) {
//				System.out.println("last dp : " + Arrays.toString(last_dp[j]));
//			}
			// last_dp 값 갱신
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 3; k++) {
					last_dp[j][k] = dp[j][k];
				}
			}
		}
		int temp = Math.min(dp[0][0], dp[0][1]);
		int min_result = Math.min(temp, dp[0][2]);
		
		temp = Math.max(dp[1][0], dp[1][1]);
		int max_result = Math.max(temp, dp[1][2]);
		System.out.println(max_result + " " + min_result);
	}
}
