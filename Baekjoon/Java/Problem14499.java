package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14499 {
    static int N, M;
    static int[][] graph;
    static int K;
    static Dice dice;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        dice = new Dice(x, y);
        K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int nowDir = Integer.parseInt(st.nextToken());
            if(dice.canGo(nowDir)){
                dice.roll(nowDir);
                if(graph[dice.x][dice.y] == 0){
                    graph[dice.x][dice.y] = dice.down.value;
                }
                else{
                    dice.down.value = graph[dice.x][dice.y];
                    graph[dice.x][dice.y] = 0;
                }
                sb.append(dice.up.value).append("\n");
            }
        }
        // 결과출력
        System.out.print(sb);
    }

    public static class Dice{
        int x;
        int y;
        Point up = new Point(1, 0);
        Point down = new Point(6, 0);
        Point left = new Point(4, 0);
        Point right = new Point(3, 0);
        Point front = new Point(5, 0);
        Point back = new Point(2, 0);

        void roll(int dir){
            if(dir == 1){
                y++;
                Point temp = down;
                down = right;
                right = up;
                up = left;
                left = temp;
            }else if(dir == 2){
                y--;
                Point temp = down;
                down = left;
                left = up;
                up = right;
                right = temp;
            }else if(dir == 3){
                x--;
                Point temp = down;
                down = back;
                back = up;
                up = front;
                front = temp;
            }else if(dir == 4){
                x++;
                Point temp = down;
                down = front;
                front = up;
                up = back;
                back = temp;
            }
        }

        boolean canGo(int dir){
            if(dir == 1){
                if(y + 1 >= M) return false;
            } else if(dir == 2){
                if(y - 1 < 0) return false;
            } else if(dir == 3){
                if(x - 1 < 0) return false;
            } else if(dir == 4){
                if(x + 1 >= N) return false;
            }
            return true;
        }

        Dice(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static class Point{
        int dir;
        int value;
        Point(int dir, int value){
            this.dir = dir;
            this.value = value;
        }
    }
}
