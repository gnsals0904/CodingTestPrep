import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2665 {
    static char[][] graph;
    static int[][] visited;
    static int N;
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    static Queue<Point> queue = new LinkedList<Point>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        setVisited();
        findMin(0, 0);
        System.out.println(visited[N - 1][N - 1]);
    }

    static void setVisited(){
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
    }

    static void findMin(int startX, int startY){
        queue.add(new Point(startX, startY, 0));
        visited[startX][startY] = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] v : vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(graph[nx][ny] == '1'){
                    if(visited[nx][ny] > p.count){
                        visited[nx][ny] = p.count;
                        queue.add(new Point(nx, ny, p.count));
                    }
                }
                else{
                    if(visited[nx][ny] > p.count + 1){
                        visited[nx][ny] = p.count + 1;
                        queue.add(new Point(nx, ny, p.count + 1));
                    }
                }
            }
        }
    }

    static class Point{
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
