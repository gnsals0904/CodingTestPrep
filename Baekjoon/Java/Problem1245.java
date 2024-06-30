package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1245 {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] vector = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int result;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]) {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    if(bfs()){
                        result++;
                    }
                    queue.clear();
                }
            }
        }
        System.out.println(result);
    }

    static boolean bfs(){
        boolean isTop = true;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] v: vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(graph[p.x][p.y] < graph[nx][ny]) isTop = false;
                if(visited[nx][ny]) continue;
                if(graph[p.x][p.y] == graph[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return isTop;
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
