package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem16136 {
	// 색종이 정보
	static int[][] graph = new int[10][10];
	// 최소값 결과
	static int result = Integer.MAX_VALUE;
	// 색종이의 남은 개수
	static int[] papers = new int[5];

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st;
		Arrays.fill(papers, 5);
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 시뮬레이션 돌려보기
		dfs(0, 0, 0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(result);
	}

	static void dfs(int start_x, int start_y, int depth) {
		// 이미 result 가 구해진 상황에서 그것보다 더 많은 경우를 탐색할 필요는 없다.
		if (depth >= result)
			return;
		if(start_y >= 10) {
			start_y = 0;
			start_x++;
		}
		// 다 검토한 경우
		if(start_y == 0 && start_x >= 10) {
			// 다 붙였다면 붙인 색종이 개수를 센다
			result = Math.min(result, depth);
			return;
		}
		// 색종이 5개중 붙일 수 있는 것을 붙인다 (큰것부터 확인한다)
		if (graph[start_x][start_y] == 1) {
			for (int w = 4; w >= 0; w--) {
				// 붙일 수 있다면 붙이고
				if (canAttach(start_x, start_y, w + 1)) {
					attach(start_x, start_y, w + 1);
					dfs(start_x, start_y + w + 1, depth + 1);
					dettach(start_x, start_y, w + 1);
				}
			}
		}
		else {
			dfs(start_x, start_y + 1, depth);
		}
	}

	// 색종이 붙이기
	static void attach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				graph[i][j] = 0;
			}
		}
		// 붙인 색종이 개수 줄이기
		papers[size - 1]--;
	}

	// 색종이 떼기
	static void dettach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				graph[i][j] = 1;
			}
		}
		// 뗀 색종이 개수 늘리기
		papers[size - 1]++;
	}

	// 색종이를 붙일 수 있는지?
	static boolean canAttach(int x, int y, int size) {
		if (x + size > 10 || y + size > 10 || papers[size - 1] == 0) {
			return false;
		}
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (graph[i][j] != 1)
					return false;
			}
		}
		return true;
	}
}
