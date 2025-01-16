import java.io.*;
import java.util.*;

class 게임_맵_최단거리 {
    static int R, C;
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        visited = new boolean[R][C];
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        int answer = bfs(maps);
        return answer;
    }
    
    static int bfs(int[][] maps){
        int time = 1;
        int size = queue.size();
        while(!queue.isEmpty()){
            for(int i = 0; i < size; i++){
                Point p = queue.poll();
                if(p.x == R-1 && p.y == C-1){
                    return time;
                }
                for(int[] v : vector){
                    int nx = p.x + v[0];
                    int ny = p.y + v[1];
                    if(!isIn(nx, ny)) continue;
                    if(visited[nx][ny]) continue;
                    if(maps[nx][ny] == 0) continue;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
            time++;
            size = queue.size();
        }
        return -1;
    }
    
    static boolean isIn(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
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
