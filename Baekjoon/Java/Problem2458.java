package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [G4] BJ 2458 줄 세우기
 * 메모리 : 36044 KB
 * 시간 : 416 ms
 * 코드 길이 : 2196 B
 * 아이디어 : 학생들의 키 순서 관계는 정점과 edge를 이용해서 유향 그래프로 표현할 수 있다.
 * 플로이드 워셜을 사용하면 모든 정점에서 다른 모든 정점으로 갈 수 있는지 확인할 수 있다.
 * 내가 갈 수 있는 정점과 나에게 오는 정점이 모두 체크되면 
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2458">
 *
 */
public class Problem2458 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 수
		int N = Integer.parseInt(st.nextToken());
		// 간선의 표현 수
		int M = Integer.parseInt(st.nextToken());
		// 유항 그래프로 표현한다
		int[][] dp = new int[N + 1][N + 1];
		// graph 초기화
		for(int i = 0; i < N + 1; i++) {
			Arrays.fill(dp[i], 501);
		}
		// 입력값받기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// a -> b
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 갈수있음을 표현
			dp[a][b] = 1;
		}
		// 플로이드 워셜 진행
		// 경유지 출발지 도착지 순서
		for(int k = 1; k < N + 1; k++) {
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
		// 결과 세기
		int result = 0;
		for(int i = 1; i < N + 1; i++) {
			boolean check = false;
			for(int j = 1; j < N + 1; j++) {
				if(i == j) continue;
				if(dp[i][j] == 501) {
					if(dp[j][i] == 501) {
						check = true;
						break;
					}
				}
			}
			if(!check) result++;
		}
		System.out.println(result);
	}
}
