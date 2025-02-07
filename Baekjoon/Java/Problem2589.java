package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2589 {
    static int R, C;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int result = Integer.MIN_VALUE;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(graph[i][j] == 'L') {
                    result = Math.max(result, bfs(i, j));
                    setVisited();
                }
            }
        }
        System.out.println(result - 1);
    }

    static int bfs(int x, int y){
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int time = 0;
        int size = queue.size();
        while(!queue.isEmpty()){
            for(int t = 0; t < size; t++){
                Point p = queue.poll();
                for(int[] v : vector){
                    int nx = p.x + v[0];
                    int ny = p.y + v[1];
                    if(!isRange(nx, ny)) continue;
                    if(visited[nx][ny]) continue;
                    if(graph[nx][ny] == 'L'){
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            size = queue.size();
            time++;
        }
        return time;
    }

    static boolean isRange(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static void setVisited(){
        for(int i = 0; i < R; i++) {
            Arrays.fill(visited[i], false);
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
