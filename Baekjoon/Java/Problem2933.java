import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2933 {
    static int R, C;
    static char[][] graph;
    static int[][] vector = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> downQueue = new LinkedList<>();
    static ArrayList<Point> downList = new ArrayList<>();
    static Stack<Point> resetPoints = new Stack<>();
    static boolean[][] visited;
    // 0 -> // 1 <-
    static int turn = 0;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            graph[i] = br.readLine().toCharArray();
        }
        int orderNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < orderNum; i++){
            int nowOrder = Integer.parseInt(st.nextToken());
            Point hitpoint = throwStick(nowOrder);
            turnChange();
            if(hitpoint.x == -1) continue;
            findCluster(hitpoint);
        }
        showGraph();
    }

    static void findCluster(Point p){
        for(int i = 0; i < 4; i++){
            int nx = p.x + vector[i][0];
            int ny = p.y + vector[i][1];
            if(!isIn(nx, ny)) continue;
            if(graph[nx][ny] == 'x'){
                if(bfs(nx, ny)){
                    Collections.sort(downList);
                    downQueue.addAll(downList);
                    downList.clear();
                    moveDown();
                }
            }
        }
    }

    static boolean bfs(int x, int y){
        queue.add(new Point(x, y));
        downList.add(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] v : vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(!isIn(nx, ny)) continue;
                if(graph[nx][ny] == '.') continue;
                if(!visited[nx][ny]){
                    if(nx == R - 1) {
                        queue.clear();
                        downList.clear();
                        setVisited();
                        return false;
                    }
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    downList.add(new Point(nx, ny));
                }
            }
        }
        setVisited();
        return true;
    }

    static void moveDown(){
        int size = downQueue.size();
        boolean flag = false;
        while (!downQueue.isEmpty()){
            for(int i = 0; i < size; i++){
                Point p = downQueue.poll();
                int nx = p.x + vector[2][0];
                if(isIn(nx, p.y)){
                    if(graph[nx][p.y] == 'x') {
                        flag = true;
                        break;
                    }
                }
                else{
                    flag = true;
                    break;
                }
                graph[nx][p.y] = 'x';
                graph[p.x][p.y] = '.';
                downQueue.add(new Point(nx, p.y));
                resetPoints.add(new Point(nx, p.y));
            }
            if(flag) {
                while (!resetPoints.isEmpty()){
                    Point p = resetPoints.pop();
                    int nx = p.x + vector[3][0];
                    graph[nx][p.y] = 'x';
                    graph[p.x][p.y] = '.';
                }
                break;
            }
            resetPoints.clear();
        }
        downQueue.clear();
    }

    static void turnChange(){
        turn = (turn + 1) % 2;
    }

    static Point throwStick(int n){
        Point p;
        if(turn == 0){
            p = new Point(R - n, 0);
        }
        else{
            p = new Point(R - n, C - 1);
        }
        while (isIn(p.x, p.y) && graph[p.x][p.y] != 'x'){
            p.x += vector[turn][0];
            p.y += vector[turn][1];
        }
        if (isIn(p.x, p.y)) {
            graph[p.x][p.y] = '.';
            return p;
        }
        return new Point(-1, -1);
    }

    static boolean isIn(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static void setVisited(){
        for(int i = 0; i < R; i++) Arrays.fill(visited[i], false);
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.x - this.x;
        }
    }

    // debug
    static void showGraph(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
