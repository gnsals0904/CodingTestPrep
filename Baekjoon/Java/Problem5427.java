import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem5427 {
    static int T, w, h;
    static char[][] graph;
    static int[][] fireTime;
    static boolean[][] visited;
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Point loc;
    static Queue<Point> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            graph = new char[h][w];
            fireTime = new int[h][w];
            visited = new boolean[h][w];
            setFireTime();
            for(int i = 0; i < h; i++) {
                graph[i] = br.readLine().toCharArray();
                for(int j = 0; j < w; j++) {
                    if(graph[i][j] == '*'){
                        queue.add(new Point(i, j));
                        fireTime[i][j] = 0;
                    }
                    if(graph[i][j] == '@'){
                        loc = new Point(i, j);
                    }
                }
            }
            startFire();
            queue.add(loc);
            visited[loc.x][loc.y] = true;
            if(!goOut()){
                sb.append("IMPOSSIBLE\n");
            }
            queue.clear();
        }
        System.out.print(sb);
    }

    static boolean goOut(){
        int time = 1;
        int cycle = queue.size();
        while(!queue.isEmpty()){
            for(int i = 0; i < cycle; i++){
                Point p = queue.poll();
                for(int[] v : vector){
                    int nx = p.x + v[0];
                    int ny = p.y + v[1];
                    if(!isIn(nx, ny)){
                        sb.append(time).append("\n");
                        return true;
                    }
                    if(graph[nx][ny] == '#') continue;
                    if(visited[nx][ny]) continue;
                    if(fireTime[nx][ny] > time || fireTime[nx][ny] == -1){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            time++;
            cycle = queue.size();
        }
        return false;
    }

    static void startFire(){
        int time = 1;
        int cycle = queue.size();
        while(!queue.isEmpty()){
            for(int i = 0; i < cycle; i++){
                Point p = queue.poll();
                for(int[] v: vector){
                    int nx = p.x + v[0];
                    int ny = p.y + v[1];
                    if(!isIn(nx, ny)) continue;
                    if(graph[nx][ny] == '#') continue;
                    if(fireTime[nx][ny] == -1){
                        fireTime[nx][ny] = time;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            time++;
            cycle = queue.size();
        }
    }

    static void setFireTime(){
        for(int i = 0; i < h; i++){
            Arrays.fill(fireTime[i], -1);
        }
    }

    static boolean isIn(int x, int y){
        return x >= 0 && x < h && y >= 0 && y < w;
    }

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

