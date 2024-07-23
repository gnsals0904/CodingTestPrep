import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem21772 {
    static int N, M;
    static char[][] graph;
    static int K;
    static Point gahee;
    static int result = 0;
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        for(int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        boolean flag = false;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(graph[i][j] == 'G'){
                    gahee = new Point(i, j);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        // input end
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int eatCount, int depth){
        if(depth == K){
            result = Math.max(result, eatCount);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = gahee.x + vector[i][0];
            int ny = gahee.y + vector[i][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(graph[nx][ny] == '#') continue;
            gahee.x = nx;
            gahee.y = ny;
            if(graph[nx][ny] == 'S') {
                graph[nx][ny] = '.';
                dfs(eatCount+1, depth+1);
                graph[nx][ny] = 'S';
            }
            else dfs(eatCount, depth + 1);
            gahee.x -= vector[i][0];
            gahee.y -= vector[i][1];
        }

    }

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
