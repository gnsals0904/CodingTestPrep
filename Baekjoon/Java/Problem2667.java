package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2667 {
    static int N;
    static char[][] graph;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int result;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> resultArr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            graph[i] = br.readLine().toCharArray();
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == '1' && !visited[i][j]){
                    resultArr.add(bfs(i , j));
                    result++;
                }
            }
        }
        Collections.sort(resultArr);
        for(int a : resultArr){
            sb.append(a).append("\n");
        }
        System.out.println(result);
        System.out.print(sb);
    }

    static int bfs(int i, int j) {
        queue.add(new Point(i, j));
        int count = 1;
        visited[i][j] = true;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] v : vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] == '1'){
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    count++;
                }
            }
        }
        return count;
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
