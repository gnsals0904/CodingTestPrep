package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [G4] BJ 11404 플로이드
 * 메모리 : 41488 KB
 * 시간 : 348 ms
 * 코드 길이 : 1680 B
 * 아이디어 : 모든 정점에서 모든 정점으로 가는 최단경로를 구해야 한다 => 플로이드 워셜 알고리즘을 사용한다.
 * 
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/11404">
 *
 */
public class Problem11404 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		// 도시의 개수 => vertex 의 개수
		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n][n];
		// graph 초기값으로 초기화
		for(int i = 0; i < n; i++) {
			Arrays.fill(graph[i], 10000001);
		}
		// graph i j
		for(int i = 0; i < n; i++) {
			graph[i][i] = 0;
		}
		// 버스의 개수 => edge 의 개수 
		int m = Integer.parseInt(br.readLine());
		// edge 정보 입력받기
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// i -> j 로 갈때 들어가는 비용
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			// graph 초기화
			graph[a][b] = Math.min(graph[a][b], cost);
		}
		// 플로이드 워셜 알고리즘 수행
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(graph[i][j] == 10000001) {
					sb.append(0).append(" ");
				}
				else {
					sb.append(graph[i][j]).append(" ");
				}
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
