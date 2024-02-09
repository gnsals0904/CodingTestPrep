package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem24460 {
    static long result = 0;
    static long[][] graph;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        graph = new long[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Long.parseLong(st.nextToken());
            }
        }
        func(graph, N);
        System.out.println(result);
    }

    public static void func(long[][] arr, int n){
        if(n == 1){
            result = arr[0][0];
            return;
        }
        long[][] temp = new long[n / 2][n / 2];
        int cnt_x = 0;
        for(int i = 0; i < n; i += 2){
            int cnt_y = 0;
            for(int j = 0; j < n; j += 2){
                long[] temp2 = new long[4];
                temp2[0] = arr[i][j];
                temp2[1] = arr[i + 1][j];
                temp2[2] = arr[i][j + 1];
                temp2[3] = arr[i + 1][j + 1];
                Arrays.sort(temp2);
                temp[cnt_x][cnt_y] = temp2[1];
                cnt_y += 1;
            }
            cnt_x += 1;
        }
        func(temp, n / 2);
    }



}
