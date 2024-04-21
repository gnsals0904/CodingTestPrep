package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1938 {
    // graph size
    static int N;
    // graph
    static char[][] graph;
    static boolean[][][] visited;

    // 0 하, 1 상, 2 우, 3 좌
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Point[] tree = new Point[3];
    static Point[] end = new Point[3];
    static int end_dir = 1;
    static int result = Integer.MAX_VALUE;
    static Queue<P_Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        // basic input
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[2][N][N];
        int count = 0;
        int cnt = 0;
        for(int i = 0; i < N; i++){
            graph[i] = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                if(graph[i][j] == 'B'){
                    tree[count++] = new Point(i, j);
                }
                if(graph[i][j] == 'E'){
                    end[cnt++] = new Point(i, j);
                }
            }
        }
        // dir 1 => 세로 0 => 가로
        int dir = 1;
        if(tree[0].x == tree[1].x) dir = 0;
        if(end[0].x == end[1].x) end_dir = 0;
        queue.add(new P_Point(tree[1].x, tree[1].y, 0, dir));
        visited[dir][tree[1].x][tree[1].y] = true;
        bfs();
        if(result == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }

    static void bfs(){
        while(!queue.isEmpty()){
            P_Point p = queue.poll();
            // 도착한 경우
            if(p.x == end[1].x && p.y == end[1].y && p.dir == end_dir){
                result = Math.min(result, p.count);
                continue;
            }
            // 일단 가는 경우
            for(int i = 0; i < 4; i++){
                int nx = p.x + vector[i][0];
                int ny = p.y + vector[i][1];
                if(!canGo(nx, ny, p.dir, i)) continue;
                if(visited[p.dir][nx][ny]) continue;
                queue.add(new P_Point(nx, ny, p.count + 1, p.dir));
                visited[p.dir][nx][ny] = true;
            }
            // 일단 돌려보는 경우
            if(canRotate(p.x, p.y)){
                // 일단 돌리기
                int n_dir = (p.dir + 1) % 2;
                // 돌린 방향을 탐색하지 않았을 경우
                if(!visited[n_dir][p.x][p.y]){
                    queue.add(new P_Point(p.x, p.y, p.count + 1, n_dir));
                    visited[n_dir][p.x][p.y] = true;
                }
            }
        }
    }

    static boolean canGo(int x, int y, int dir, int go){
        // 가로
        if(dir == 0){
            // 가로, 좌우
            if(go >= 2){
                if(y - 1 < 0 || y + 1 >= N) return false;
                if(graph[x][y] == '1' || graph[x][y - 1] == '1' || graph[x][y + 1] == '1') return false;
            }
            // 가로, 상하
            else{
                if(x < 0 || x >= N) return false;
                if(graph[x][y] == '1' || graph[x][y - 1] == '1' || graph[x][y + 1] == '1') return false;
            }
        }
        // 세로
        else{
            // 세로, 좌우
            if(go >= 2){
                if(y < 0 || y >= N) return false;
                if(graph[x][y] == '1' || graph[x - 1][y] == '1' || graph[x + 1][y] == '1') return false;
            }
            // 세로, 상하
            else{
                if(x - 1 < 0 || x + 1 >= N) return false;
                if(graph[x][y] == '1' || graph[x - 1][y] == '1' || graph[x + 1][y] == '1') return false;
            }
        }
        return true;
    }

    // x y 기준 9칸에 범위 안 & 통나무 없어야함
    static boolean canRotate(int x, int y){
        for(int i = x - 1; i <= x + 1; i++){
            for(int j = y - 1; j <= y + 1; j++){
                // graph out
                if(i < 0 || i >= N || j < 0 || j >= N) return false;
                // tree
                if(graph[i][j] == '1') return false;
            }
        }
        return true;
    }

    // x y Point
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // dir 1 => 세로 0 => 가로
    static class P_Point extends Point{
        int count;
        int dir;
        P_Point(int x, int y, int count, int dir) {
            super(x, y);
            this.count = count;
            this.dir = dir;
        }
    }
}
