package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16946 {
	// graph size
	static int N, M;
	// graph info
	static char[][] graph;
	// each island number
	static int[][] visited;
	// land number
	static ArrayList<Integer> island_num = new ArrayList<>();
	static Queue<Point> queue = new LinkedList<Point>();
	static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	// result graph
	static int[][] result;
	// is used
	static boolean[] isused;
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		// graph size
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		// -1 => not visited
		visited = new int[N][M];
		result = new int[N][M];
		// graph input
		for (int i = 0; i < N; i++) {
			// graph input
			graph[i] = br.readLine().toCharArray();
			// setting visited
			Arrays.fill(visited[i], -1);
		}
		// count 0
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == '0' && visited[i][j] == -1) {
					queue.add(new Point(i, j));
					visited[i][j] = island_num.size();
					count_land(island_num.size());
				}
			}
		}
		// make isused
		isused = new boolean[island_num.size()];
		
		
		// record result
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == '1') {
					result[i][j] = record_result(i, j);
					Arrays.fill(isused, false);
				}
			}
		}
		// show result
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}

	// record result
	static int record_result(int x, int y) {
		int result = 1;
		for (int[] v : vector) {
			int nx = x + v[0];
			int ny = y + v[1];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			if (graph[nx][ny] == '0' && !isused[visited[nx][ny]]) {
				isused[visited[nx][ny]] = true;
				result += island_num.get(visited[nx][ny]);
				continue;
			}
		}
		return result % 10;
	}

	// count
	static void count_land(int num) {
		int count = 1;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int[] v : vector) {
				int nx = p.x + v[0];
				int ny = p.y + v[1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (graph[nx][ny] == '1')
					continue;
				if (visited[nx][ny] == -1) {
					visited[nx][ny] = num;
					queue.add(new Point(nx, ny));
					count++;
				}
			}
		}
		island_num.add(count % 10);
	}

	// Point class
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
