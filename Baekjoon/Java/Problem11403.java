package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S1] BJ 11403 경로 찾기
 * 메모리 : 14148 KB
 * 시간 : 164 ms
 * 코드 길이 : 1251 B
 * 아이디어 : 모든 정점에서 모든 정점으로 가는 최단경로를 구해야 한다 => 플로이드 워셜 알고리즘을 사용한다.
 * 
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/11404">
 *
 */
public class Problem11403 {
	public static void main(String[] args) throws IOException {
		// 입력받기 위해서 생성
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		// 그래프에 값을 입력받는다
		int[][] graph = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 0) {
					graph[i][j] = 1000;
				}
			}
		}
		// 플로이드 워셜 진행
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 초기화해놓은 맥스값이 그대로면 0으로 바꾸고 출력한다 => 가는 길이 없는 것이므로
				if(graph[i][j] == 1000) {
					sb.append(0).append(" ");
				}
				else {
					sb.append(1).append(" ");
				}
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
