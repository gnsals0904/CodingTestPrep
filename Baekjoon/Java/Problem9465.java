package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9465 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 진행
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][N];
			StringTokenizer st;
			// 2줄 입력받기
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(N == 1) {
				// 정답 출력
				sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
				continue;
			}
			// y == 1 일때
			dp[0][1] = dp[1][0] + dp[0][1];
			dp[1][1] = dp[0][0] + dp[1][1];
			// 나머지
			for(int i = 2; i < N; i++) {
				// 윗줄 채우기
				int temp = Math.max(dp[0][i-2], dp[1][i-2]);
				dp[0][i] = Math.max(temp, dp[1][i-1]) + dp[0][i];
				// 아랫줄 채우기
				temp = Math.max(dp[0][i-2], dp[1][i-2]);
				dp[1][i] = Math.max(temp, dp[0][i-1]) + dp[1][i];
			}
			// 정답 출력
			sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
		}
		System.out.println(sb);
	}
}
