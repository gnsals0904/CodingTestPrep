package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10994 {
    static int N;
    static int size;
    static char[][] graph;
    static int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        size = 2 * (N - 1) * 2 + 1;
        graph = new char[size][size];
        dfs(0, 0, size);
        showResult();
    }

    static void dfs(int startX, int startY, int len){
        if(len == 1){
            graph[startX][startY] = '*';
            return;
        }
        int dx = startX;
        int dy = startY;
        int dir = 0;
        while(true){
            if(!isIn(dx, dy, startX, startY, len)){
                dx -= vector[dir][0];
                dy -= vector[dir][1];
                dir++;
                if(dir == 4) break;
            }
            graph[dx][dy] = '*';
            dx += vector[dir][0];
            dy += vector[dir][1];
        }
        dfs(startX + 2, startY + 2, len - 4);
    }

    static boolean isIn(int x, int y, int startX, int startY, int len){
        return x >= startX && x < startX + len && y >= startY && y < startY + len;
    }

    static void showResult(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(graph[i][j] == '*'){
                    sb.append('*');
                }
                else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
