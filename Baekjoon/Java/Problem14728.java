package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14728 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		Study[] studyArr = new Study[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Study temp = new Study(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			studyArr[i] = temp;

		}
		int[] dp = new int[T + 1];
		dp[0] = 0;
		// 초기 dp table 설정
		for (int i = 1; i < T + 1; i++) {
			if (studyArr[0].time <= i) {
				dp[i] = studyArr[0].score;
			} else {
				dp[i] = 0;
			}
		}

		for (int j = 1; j < N; j++) {
			for (int i = T; i > 0; i--) {
				// 이 공부를 처리할 수 있으면
				if (studyArr[j].time <= i) {
					dp[i] = Math.max(dp[i], dp[i - studyArr[j].time] + studyArr[j].score);
				}
			}
//			System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[T]);
	}

	static class Study {
		int time;
		int score;
		boolean isUsed;

		Study(int time, int score) {
			this.time = time;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Study [time=" + time + ", score=" + score + "]";
		}
	}
}
