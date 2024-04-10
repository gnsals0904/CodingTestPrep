package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14442 {
    static char[][] graph;
    static int[][] visited;
    // graph size
    static int N;
    static int M;
    static Queue<Point> queue = new LinkedList<>();
    // 하 상 우 좌
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        // graph 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 벽 부술수있는 횟수
        int K = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        visited = new int[N][M];
        // visited -1 로 초기화
        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], -1);
        }
        for(int i = 0; i < N; i++){
            graph[i] = br.readLine().toCharArray();
        }
        // bfs start
        queue.add(new Point(0, 0, K));
        visited[0][0] = K;
        bfs();
    }

    static void bfs(){
        int time = 1;
        int size;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                Point p = queue.poll();
//                System.out.println(p);
                // 도착
                if(p.x == N-1 && p.y == M-1){
                    System.out.println(time);
                    return;
                }
                for(int[] v : vector){
                    int nx = p.x + v[0];
                    int ny = p.y + v[1];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(p.remain == 0 && graph[nx][ny] == '1') continue;
                    if(p.remain == 0 && visited[nx][ny] >= 0) continue;
                    // 더 멀리 갈 가능성이 있다
                    if(graph[nx][ny] == '1' && visited[nx][ny] < p.remain - 1){
                        queue.add(new Point(nx, ny, p.remain - 1));
                        visited[nx][ny] = p.remain - 1;
                    }
                    if(graph[nx][ny] == '0' && visited[nx][ny] < p.remain){
                        queue.add(new Point(nx, ny, p.remain));
                        visited[nx][ny] = p.remain;
                    }
                }
            }
            time++;

        }
        // 도착 못한 경우
        System.out.println(-1);
    }

    // Point class
    static class Point{
        int x;
        int y;
        int remain;
        Point(int x, int y, int remain){
            this.x = x;
            this.y = y;
            this.remain = remain;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", remain=" + remain +
                    '}';
        }
    }
}
