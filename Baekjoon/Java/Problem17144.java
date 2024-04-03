package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G4] BJ 17144 미세먼지 안녕!
 * 메모리 : 13292 KB
 * 시간 : 244 ms
 * 코드 길이 : 4989 B
 * 아이디어 : 문제의 조건에 맞게 상황을 시뮬레이션 해준다.
 * 
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/17144">
 *
 */
public class Problem17144 {
	// 세로
	static int R;
	// 가로
	static int C;
	// 초
	static int T;
	// graph
	static int[][] graph;
	// temp graph
	static int[][] after_move_graph;
	// 공기 청정기 위치
	static Point[] machine = new Point[2];
	// 공기가 확산되는 방향
	static int[][] vector = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	// 위쪽 사이클 방향 위, 오른쪽, 아래, 왼쪽
	static int[][] up_vector = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	// 아래쪽 사이클 방향 아래, 오른쪽, 위, 왼쪽
	static int[][] down_vector = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		after_move_graph = new int[R][C];
		int machine_c = 0;
		// 입력 받고, 공기청정기 위치 저장
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == -1) {
					machine[machine_c] = new Point(i, j);
					machine_c++;
				}
			}
		}
		while(T-- > 0) {
			// 미세먼지가 퍼지고
			separate();
			// graph 복사하고
			moveGraph();
			// 먼지를 이동시키고
			moveDust();
		}
		int result = countDust();
		System.out.println(result);
	}
	
	// 남은 먼지 양 세기
	static int countDust() {
		int result = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				result += graph[i][j];
			}
		}
		return result + 2;
	}
	
	
	// 미세먼지가 이동한다
	static void moveDust() {
		// 기계 위쪽의 x y 좌표 => 위쪽 사이클
		int x = machine[0].x;
		int y = machine[0].y;
		// 위쪽 사이클 진행
		int dir = 0;
		while(true) {
			int nx = x + up_vector[dir][0];
			int ny = y + up_vector[dir][1];
			// 범위 밖으로 벗어나면 안된다
			if(nx < 0 || nx >= machine[0].x + 1 || ny < 0 || ny >= C) {
				// 방향 변경
				dir++;
				continue;
			}
			// 공기 청정기가 있는 곳이면 빨려들어간다
			if(graph[x][y] == -1) {
				x = nx;
				y = ny;
				continue;
			}
			// 덮어 씌우기
			graph[x][y] = graph[nx][ny];
			// 다 돌았으면 탈출
			if(nx == machine[0].x && ny == machine[0].y) {
				graph[x][y] = 0;
				break;
			}
			x = nx;
			y = ny;
		}
		
		// 기계 위쪽의 x y 좌표 => 아래쪽 사이클
		x = machine[1].x;
		y = machine[1].y;
		// 위쪽 사이클 진행
		dir = 0;
		while(true) {
			int nx = x + down_vector[dir][0];
			int ny = y + down_vector[dir][1];
			// 범위 밖으로 벗어나면 안된다
			if(nx >= R || nx < machine[1].x || ny < 0 || ny >= C) {
				// 방향 변경
				dir++;
				continue;
			}
			// 공기 청정기가 있는 곳이면 빨려들어간다
			if(graph[x][y] == -1) {
				x = nx;
				y = ny;
				continue;
			}
			// 덮어 씌우기
			graph[x][y] = graph[nx][ny];
			// 다 돌았으면 탈출
			if(nx == machine[1].x && ny == machine[1].y) {
				graph[x][y] = 0;
				break;
			}
			x = nx;
			y = ny;
		}
	}
	
	// 미세먼지가 확산된다
	static void separate() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				// 미세먼지가 있는 곳은 4방향으로 확산된다
				if(graph[i][j] > 0) {
					int count = 0;
					int split_dust = graph[i][j] / 5;
					for(int[] v : vector) {
						int nx = i + v[0];
						int ny = j + v[1];
						// 벽 밖으로는 노노
						if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
							continue;
						}
						// 확산된곳이 마침 공기청정기가 있는 쪽이면
						if(graph[nx][ny] == -1) {
							continue;
						}
						count++;
						// 확산시키기
						after_move_graph[nx][ny] += split_dust;
					}
					// 확산된만큼 빠진다
					after_move_graph[i][j] += graph[i][j] - (split_dust * count);
				}
			}
		}
	}
	
	// 확산된 미세먼지 그래프를 원본 그래프로 옮기고, 확산된 미세먼지 그래프를 초기화한다
	static void moveGraph() {
		// graph 옮기기
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				graph[i][j] = after_move_graph[i][j];
				// 미세먼지 그래프 초기화
				after_move_graph[i][j] = 0;
			}
		}
		// 공기청정기 위치 넣기
		for(Point p : machine) {
			graph[p.x][p.y] = -1;
		}
	}
	
	// x y 좌표
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	// debug
	static void showGraph() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
