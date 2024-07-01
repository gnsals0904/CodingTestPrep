package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem23288 {
    static int N, M, K;
    static int[][] graph;
    static int[][] dp;
    static boolean[][] visited;
    // 동 남 서 북
    static int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<Point> queue = new LinkedList<>();
    static Set<Point> set = new HashSet<>();
    static Dice dice = new Dice(0, 0);
    static int result = 0;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // fill dp table
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    queue.add(new Point(i, j));
                    set.add(new Point(i, j));
                    visited[i][j] = true;
                    int tempResult = bfs();
                    fillDP(tempResult);
                    set.clear();
                }
            }
        }
        // roll dice
        for(int i = 0; i < K; i++){
            dice.roll();
            result += dp[dice.x][dice.y];
        }
        System.out.println(result);
    }

    static void fillDP(int result){
        for(Point p : set){
            dp[p.x][p.y] = result;
        }
    }

    static int bfs(){
        Point p = queue.peek();
        int result = graph[p.x][p.y];
        int count = 1;
        while (!queue.isEmpty()){
            p = queue.poll();
            for(int[] v : vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(graph[p.x][p.y] == graph[nx][ny]){
                    count++;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    set.add(new Point(nx, ny));
                }
            }
        }
        result = result * count;
        return result;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Dice extends Point{
        int dir = 0;
        int up = 1;
        int down = 6;
        int left = 4;
        int right = 3;
        int front = 5;
        int back = 2;
        Dice(int x, int y) {
            super(x, y);
        }

        void roll(){
            move();
            changeNum();
            if(down > graph[x][y]){
                dir = (dir + 1) % 4;
            }
            else if(down < graph[x][y]){
                dir--;
                if(dir < 0) dir += 4;
            }
        }

        void move(){
            int nx = x + vector[dir][0];
            int ny = y + vector[dir][1];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                dir = (dir + 2) % 4;
                nx = x + vector[dir][0];
                ny = y + vector[dir][1];
            }
            x = nx;
            y = ny;
        }

        void changeNum(){
            int temp = down;
            if(dir == 0){
                down = right;
                right = up;
                up = left;
                left = temp;
            } else if(dir == 1){
                down = front;
                front = up;
                up = back;
                back = temp;
            } else if(dir == 2){
                down = left;
                left = up;
                up = right;
                right = temp;
            } else if(dir == 3){
                down = back;
                back = up;
                up = front;
                front = temp;
            }
        }
    }
}
