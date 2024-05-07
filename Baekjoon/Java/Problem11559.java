package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem11559 {
	static char[][] graph;
	static boolean[][] visited;
	static int[][] vector = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int N = 12, M = 6;
	static Queue<Point> aqueue = new LinkedList<>();
	static Queue<Point> boom = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		graph = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		int result = 0;
		while(findPuyo()) {
			goDown();
			result++;
			setVisited();
		}
		System.out.println(result);
	}
	
	// 4개가 붙어있는 뿌요들을 체크한다
	static boolean findPuyo() {
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] != '.' && !visited[i][j]) {
					aqueue.add(new Point(i, j));
					visited[i][j] = true;
					bfs();
					// 연쇄 폭발
					if(boom.size() >= 4) {
						flag = true;
						while(!boom.isEmpty()) {
							Point p = boom.poll();
							graph[p.x][p.y] = '.';
						}
					}
					boom.clear();
				}
			}
		}
		return flag;
	}
	
	// 연결된 뿌요들을 체크한다
	static void bfs() {
		while(!aqueue.isEmpty()) {
			Point p = aqueue.poll();
			boom.add(new Point(p.x, p.y));
			for(int[] v : vector) {
				int nx = p.x + v[0];
				int ny = p.y + v[1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(graph[nx][ny] != graph[p.x][p.y]) continue;
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					aqueue.add(new Point(nx, ny));
				}
			}
		}
	}
	
	
	// 뿌요들을 밑으로 내린다
	static void goDown() {
		Queue<Character> queue = new LinkedList<Character>();
		int num = 0;
		for(int j = 0; j < M; j++) {
			for(int i = N - 1; i >= 0; i--) {
				if(graph[i][j] == '.') continue;
				queue.add(graph[i][j]);
			}
			num = queue.size();
			for(int i = N - 1; i >= 0; i--) {
				if(queue.isEmpty()) break;
				graph[i][j] = queue.poll();
			}
			for(int i = N - 1 - num; i >= 0; i--) {
				graph[i][j] = '.';
			}
			queue.clear();
		}
	}
	
	// reset visited
	static void setVisited() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}
	
	// Point class
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
}
