package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem9328 {
    static int T;
    static int h, w;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<Point> queue = new LinkedList<>();
    static Set<Character> keySet = new HashSet<>();
    static ArrayList<Point> openDoors = new ArrayList<>();
    static int docNum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph = new char[h + 2][w + 2];
            visited = new boolean[h + 2][w + 2];
            setStartStatus();
            for (int i = 1; i < h + 1; i++) {
                String inputs = br.readLine();
                for(int j = 1; j < w + 1; j++){
                    graph[i][j] = inputs.charAt(j - 1);
                }
            }
            fillGraphEdge();
            queue.add(new Point(0, 0));
            visited[0][0] = true;
            String keys = br.readLine();
            if(!keys.equals("0")){
                for(int i = 0; i < keys.length(); i++) {
                    keySet.add(keys.charAt(i));
                }
            }
            while(bfs()){
                resetVisited();
                for(Point p : openDoors){
                    visited[p.x][p.y] = true;
                    queue.add(new Point(p.x, p.y));
                }
                queue.add(new Point(0, 0));
                visited[0][0] = true;
                openDoors.clear();
            }
            sb.append(docNum).append("\n");
        }
        System.out.print(sb);
    }

    static boolean bfs(){
        boolean openDoorCycle = false;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] v : vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(!isIn(nx, ny)) continue;
                if(graph[nx][ny] == '*') continue;
                if(visited[nx][ny]) continue;
                if(isUpper(graph[nx][ny])){
                    char lower = chgLower(graph[nx][ny]);
                    if(!keySet.contains(lower)) {
                        continue;
                    } else{
                        openDoorCycle = true;
                        openDoors.add(new Point(nx, ny));
                        graph[nx][ny] = '.';
                    }
                } else if(graph[nx][ny] == '$'){
                    graph[nx][ny] = '.';
                    docNum++;
                }
                else if(isLower(graph[nx][ny])){
                    keySet.add(graph[nx][ny]);
                    graph[nx][ny] = '.';
                    openDoorCycle = true;
                }
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
        return openDoorCycle;
    }

    static void fillGraphEdge(){
        for(int j = 0; j < w + 2; j++){
            graph[0][j] = '.';
            graph[h+1][j] = '.';
        }
        for(int i = 0; i < h + 2; i++){
            graph[i][0] = '.';
            graph[i][w+1] = '.';
        }
    }

    static void setStartStatus(){
        queue.clear();
        keySet.clear();
        openDoors.clear();
        docNum = 0;
    }

    static void resetVisited(){
        for(int i = 0; i < h + 2; i++){
            Arrays.fill(visited[i], false);
        }
    }

    static char chgLower(char c){
        return (char) (c - 'A' + 'a');
    }

    static boolean isUpper(char c){
        return Character.isUpperCase(c);
    }

    static boolean isLower(char c){
        return Character.isLowerCase(c);
    }

    static boolean isIn(int x, int y){
        return x >= 0 && x < h + 2 && y >= 0 && y < w + 2;
    }

    static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
