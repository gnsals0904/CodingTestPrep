package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2448 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        // size
        int N = Integer.parseInt(br.readLine());
        // array create
        arr = new char[N][N * 2];
        func(0, 0, N);
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N * 2; j++){
                if(arr[i][j] == '*') sb.append(arr[i][j]);
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void func(int x, int y, int depth){
        if(depth == 3){
            // 1행
            arr[x + 2][y] = '*';
            arr[x + 2][y + 1] = '*';
            arr[x + 2][y + 2] = '*';
            arr[x + 2][y + 3] = '*';
            arr[x + 2][y + 4] = '*';
            // 2행
            arr[x + 1][y + 1] = '*';
            arr[x + 1][y + 3] = '*';
            // 3행
            arr[x][y + 2] = '*';
            return;
        }
        // 맨 위
        func(x, y + depth/2, depth/2);
        // 아래 왼쪽
        func(x + depth/2, y,depth/2);
        // 아래 오른쪽
        func(x + depth/2, y+depth, depth/2);
    }
}
