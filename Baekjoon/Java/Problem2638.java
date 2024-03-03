import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2638 {
    static int N;
    static int M;
    // 하, 상, 좌, 우
    static int[][] vector = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int[][] graph;
    static boolean[][] visited;
    static int[][] count_graph;
    static int result;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
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
        while (bfs()){
            setVisited();
            melting();
            result++;
        }
        System.out.println(result);
    }

    public static boolean bfs(){
        boolean flag = false;
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] v : vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }
                if(graph[nx][ny] > 0){
                    flag = true;
                    graph[nx][ny]++;
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
        return flag;
    }

    static void melting(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(graph[i][j] == 2){
                    graph[i][j] = 1;
                }
                else if(graph[i][j] > 2){
                    graph[i][j] = 0;
                }
            }
        }
    }

    public static void setVisited(){
        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], false);
        }
    }

    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void show_graph(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
