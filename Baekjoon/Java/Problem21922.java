import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem21922 {
    static int N, M;
    static int[][] graph;
    static ArrayList<Point> startWindLocs = new ArrayList<>();
    static Queue<Wind> queue = new LinkedList<Wind>();
    static boolean[][][] visited;
    // 하 상 우 좌
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M][4];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 9){
                    startWindLocs.add(new Point(i, j));
                }
            }
        }
        if(startWindLocs.isEmpty()){
            System.out.println(0);
            return;
        }
        startWind();
        simulateWind();
        System.out.println(countSeat());
    }

    static void simulateWind(){
        while(!queue.isEmpty()){
            Wind wind = queue.poll();
            visited[wind.x][wind.y][wind.dir] = true;
            wind.dir = changeDir(wind.x, wind.y, wind.dir);
            int nx = wind.x + vector[wind.dir][0];
            int ny = wind.y + vector[wind.dir][1];
            if(!isIn(nx, ny)) continue;
            if(visited[nx][ny][wind.dir]) continue;
            queue.add(new Wind(nx, ny, wind.dir));
        }
    }

    static void startWind(){
        for(Point start: startWindLocs){
            for(int i = 0; i < 4; i++){
                visited[start.x][start.y][i] = true;
                int nx = start.x + vector[i][0];
                int ny = start.y + vector[i][1];
                if(!isIn(nx, ny)) continue;
                queue.add(new Wind(nx, ny, i));
            }
        }
    }

    static int countSeat(){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                boolean flag = false;
                for(int k = 0; k < 4; k++) {
                    if (visited[i][j][k]) {
                        flag = true;
                        break;
                    }
                }
                if(flag) count++;
            }
        }
        return count;
    }

    static int changeDir(int x, int y, int dir){
        if(graph[x][y] == 1){
            if(dir == 2) return 3;
            else if(dir == 3) return 2;
        } else if(graph[x][y] == 2){
            if(dir == 0) return 1;
            else if(dir == 1) return 0;
        } else if(graph[x][y] == 3){
            if(dir == 0) return 3;
            else if(dir == 1) return 2;
            else if(dir == 2) return 1;
            else if(dir == 3) return 0;
        } else if(graph[x][y] == 4) {
            return (dir + 2) % 4;
        }
        return dir;
    }

    static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Wind extends Point{
        int dir;

        Wind(int x, int y, int dir) {
            super(x, y);
            this.dir = dir;
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
