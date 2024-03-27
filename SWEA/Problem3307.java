package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [D3] SWEA 3307 최장 증가 부분 수열
 * 메모리 : 28,376 KB
 * 시간 : 144 ms
 * 코드 길이 : 1,720 B
 * 아이디어 : 규칙에 맞게 DP 배열을 채워준다. DP 테이블의 i 번째 요소는 LIS 구성의 마지막으로 하는 최장길이임에 주의한다.
 *
 * @author 김훈민
 * @see <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr">
 *
 */

public class Problem3307 {
	public static void main(String[] args) throws IOException {
		// Input 입력받기
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		// 테스트 케이스 개수 입력받기
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 진행
		for(int tc = 1; tc < T + 1; tc++) {
			// 수열의 길이 입력받기
			int N = Integer.parseInt(br.readLine());
			// 배열의 크기와 dp 배열의 크기를 선언한다
			int[] arr = new int[N];
			int[] dp = new int[N + 1];
			// 마지막은 0으로 채워준다
			dp[N] = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 배열의 밸류 입력받아서 채워놓고 dp 값 초기화한다
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i] = 0;
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// i => 지금 검토하는 값
					// j => 지금 검토하는 값이 어디 자리에 들어가야하는지 확인하는 포인터
					// 내가 검토하는 값이 dp j 보다 작으면 그 자리는 나의 자리이다
					if(arr[i] < dp[j]) {
						dp[j] = arr[i];
						break;
					}
					// 내가 들어갈 값이 안나오면 맨 뒤에 붙으면 돼
					if(dp[j] == 0) {
						dp[j] = arr[i];
						break;
					}
				}
			}
			// dp 테이블 채웠으면 길이 확인
			int max_len = 0;
			for(int i = 0; i < N + 1; i++) {
				// 초기화 된 값이 나오면 딱 그 길이까지 채운것이다
				if(dp[i] == 0) {
					max_len = i;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(max_len).append("\n");
		}
		System.out.print(sb);
	}
}
