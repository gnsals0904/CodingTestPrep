package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Problem16234 {
	// 인구 그래프
	static int[][] graph;
	// 분할, visited
	static int[][] divide;
	static int N, L, R;
	static Queue<Point> queue = new LinkedList<>();
	static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static ArrayList<ArrayList<Point>> points = new ArrayList<>();
	static int nums;
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = N * N;
		// between L and R
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		divide = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		int count = 1;
		while(true) {
			count = 1;
			// 국경 나누기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(divide[i][j] == 0) {
						queue.add(new Point(i, j));
						divide[i][j] = count;
						divContry(count);
						count++;
					}
				}
			}
			// 국경 나눌것이 없으면 끝
			if(count == nums + 1) {
				break;
			}
			// 인구 이동
			calcPopulation(count - 1);
			result++;
			resetDivide();
		}
		System.out.println(result);
	}
	
	
	
	// 인구 이동
	static void calcPopulation(int max_num) {
		int[] nums = new int[max_num + 1];
		int[] counts = new int[max_num + 1];
		Arrays.fill(nums, 0);
		Arrays.fill(counts, 0);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				nums[divide[i][j]] += graph[i][j];
				counts[divide[i][j]]++;
			}
		}
		int[] res = new int[max_num + 1];
		res[0] = 0;
		for(int i = 1; i < max_num + 1; i++) {
			res[i] = nums[i] / counts[i]; 
		}
		// 인구 옮기기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				graph[i][j] = res[divide[i][j]];
			}
		}
	}
	
	// 국경 구분
	static void divContry(int num) {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int[] v : vector) {
				int nx = p.x + v[0];
				int ny = p.y + v[1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				// 방문했음
				if(divide[nx][ny] != 0) continue;
				// 열린다
				if(Math.abs(graph[p.x][p.y] - graph[nx][ny]) >= L && Math.abs(graph[p.x][p.y] - graph[nx][ny]) <= R) {
					queue.add(new Point(nx, ny));
					divide[nx][ny] = num;
				}
			}
		}
	}
	
	// divide 를 리셋한다
	static void resetDivide() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(divide[i], 0);
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
