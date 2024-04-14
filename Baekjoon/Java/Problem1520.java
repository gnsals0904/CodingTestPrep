package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1520 {
    // graph size
    static int N, M;
    // graph info
    static int[][] graph;
    // vector
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static PriorityQueue<Point> pqueue = new PriorityQueue<>();
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        // graph size input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        dp = new int[N][M];
        // graph info input
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // start
        pqueue.add(new Point(0 ,0, graph[0][0]));
        dp[0][0] = 1;
        bfs();
        System.out.println(dp[N-1][M-1]);
    }

    // bfs
    static void bfs(){
        while (!pqueue.isEmpty()){
            Point p = pqueue.poll();
            for(int[] v : vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(graph[p.x][p.y] <= graph[nx][ny]) continue;
                if(dp[nx][ny] == 0){
                    pqueue.add(new Point(nx, ny, graph[nx][ny]));
                }
                dp[nx][ny] += dp[p.x][p.y];
            }
        }
    }

    // Point class
    static class Point implements Comparable {
        int x;
        int y;
        int value;
        Point(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }


        @Override
        public int compareTo(Object o) {
            return ((Point) o).value - this.value;
        }
    }
}
