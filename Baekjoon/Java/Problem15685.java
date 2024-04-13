package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem15685 {
    // direction list
    static ArrayList<Integer> dir_list = new ArrayList<>();
    // dragon curve points
    static Stack<Point> Points = new Stack<>();
    static boolean[][] graph = new boolean[101][101];
    static int result;
    // 방향 vector 우, 상, 좌, 하
    static int[][] vector = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            makeCurve(x, y, dir, g);
//            showAll();
            drawGraph();
//            showGraph();
            Points.clear();
            dir_list.clear();
        }
        countSquare();
        System.out.println(result);
    }

    static void showGraph(){
        System.out.println("---- graph ----");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(graph[i][j]){
                    sb.append(1);
                }
                else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // debug
    static void showAll(){
        System.out.println("---- Points ----");
        System.out.println(Points.toString());
        System.out.println("---- dir list ----");
        System.out.println(dir_list.toString());
    }

    // make dragon curve
    static void makeCurve(int x, int y, int dir, int g){
        int now_g = 0;
        Points.add(new Point(x, y));
        dir_list.add(dir);
        int d = dir_list.get(dir_list.size() - 1);
        int nx = Points.peek().x + vector[d][0];
        int ny = Points.peek().y + vector[d][1];
        Points.add(new Point(nx, ny));
        while(now_g != g){
            now_g++;
            for(int i = dir_list.size() - 1; i >= 0; i--){
                d = (dir_list.get(i) + 1) % 4;
                nx = Points.peek().x + vector[d][0];
                ny = Points.peek().y + vector[d][1];
                Points.add(new Point(nx, ny));
                dir_list.add(d);
            }
        }
    }

    // draw graph
    static void drawGraph(){
        while (!Points.isEmpty()){
            Point p = Points.pop();
            if(p.x < 0 || p.x >= 101 || p.y < 0 || p.y >= 101) continue;
            graph[p.x][p.y] = true;
        }
    }

    // count Square
    static void countSquare(){
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(graph[i][j] && graph[i + 1][j] && graph[i][j + 1] && graph[i + 1][j + 1]){
                    result++;
                }
            }
        }
    }


    // Point class
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
