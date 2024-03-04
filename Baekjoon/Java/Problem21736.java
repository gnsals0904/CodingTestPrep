package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem21736 {
	static int N, M;
	static char[][] graph;
	static boolean[][] visited;
	static int result;
	static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		// I 의 위치를 찾는다
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(graph[i][j] == 'I') {
					queue.add(new Point(i, j));
					visited[i][j] = true;
					break;
				}
			}
		}
		bfs();
		if(result == 0) {
			System.out.println("TT");
		}else {
			System.out.println(result);
		}
		
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int[] v : vector) {
				int nx = p.x + v[0];
				int ny = p.y + v[1];
				// graph 밖으로 나가면 ㄴㄴ
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				// 벽은 못가
				if(graph[nx][ny] == 'X') {
					continue;
				}
				// 방문한적없으면 고
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					// 사람을 만나면 증가
					if(graph[nx][ny] == 'P') {
						result++;
					}
					// 큐에 넣고
					queue.add(new Point(nx, ny));
				}
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
