package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1726 {
    static int R, C;
    static int[][] graph;
    static int[][] vector = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][][] visited;
    static Robot targetLoc;
    static Queue<Robot> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new int[R][C];
        visited = new boolean[R][C][4];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Robot startLoc = new Robot(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, chgDir(Integer.parseInt(st.nextToken())));
        st = new StringTokenizer(br.readLine());
        targetLoc = new Robot(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, chgDir(Integer.parseInt(st.nextToken())));
        queue.add(startLoc);
        visited[startLoc.x][startLoc.y][startLoc.dir] = true;
        int time = 0;
        int size = queue.size();
        while (!queue.isEmpty()) {
            for(int s = 0; s < size; s++) {
                Robot cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                int dir = cur.dir;
                if(x == targetLoc.x && y == targetLoc.y && dir == targetLoc.dir) {
                    System.out.println(time);
                    return;
                }
                for(int i = 1; i < 4; i++){
                    Point p = move(x, y, dir, i);
                    if(!isIn(p.x, p.y)) break;
                    if(!canGo(p.x, p.y)) break;
                    if(visited[p.x][p.y][dir]) continue;
                    visited[p.x][p.y][dir] = true;
                    queue.add(new Robot(p.x, p.y, dir));
                }

                int nRdir = turnRight(dir);
                if(!visited[cur.x][cur.y][nRdir]){
                    visited[cur.x][cur.y][nRdir] = true;
                    queue.add(new Robot(cur.x, cur.y, nRdir));
                }

                int nLdir = turnLeft(dir);
                if(!visited[cur.x][cur.y][nLdir]){
                    visited[cur.x][cur.y][nLdir] = true;
                    queue.add(new Robot(cur.x, cur.y, nLdir));
                }
            }
            time++;
            size = queue.size();
        }
    }



    static class Robot {
        int x;
        int y;
        int dir;

        Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int turnRight(int dir){
        return (dir + 1) % 4;
    }

    static int turnLeft(int dir){
        if(dir-1 < 0) return dir = 3;
        else return dir-1;
    }

    static boolean isIn(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static boolean canGo(int x, int y){
        return graph[x][y] == 0;
    }

    static int chgDir(int dir){
        if(dir == 4) return 0;
        else if(dir == 1) return 1;
        else if(dir == 2) return 3;
        else return 2;
    }

    static Point move(int x, int y, int dir, int value) {
        x = x + vector[dir][0]*value;
        y = y + vector[dir][1]*value;
        return new Point(x, y);
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
