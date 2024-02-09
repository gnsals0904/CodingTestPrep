package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2615 {
    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
    static int result_x = -1, result_y = -1;
    static int start_x, start_y;
    static int block_cnt;
    public static void dfs(int x, int y, int count, int d) {
        int nx = x + vector[d][0];
        int ny = y + vector[d][1];
        // 맵 밖으로 나가면 지금까지 센 개수 return
        if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
//			System.out.println("map out => nx : " + nx + " " + "ny : " + ny + " :::  " + count);
            block_cnt += count;
            return;
        }
        // 색 다르면 지금까지 센 개수 return
        if (graph[nx][ny] != color) {
//			System.out.println("color diff => nx : " + nx + " " + "ny : " + ny + " :::  " + count);
            block_cnt += count;
            return;
        }
        dfs(nx, ny, count + 1, d);
    }

    static int color;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st;
        int result = 0;
        // 2차원 배열 입력 받을 graph 이다.
        graph = new int[19][19];
        // 2차원 배열에 입력을 받는다.
        for (int i = 0; i < 19; i++) {
            String temp_input = br.readLine();
            st = new StringTokenizer(temp_input);
            for (int j = 0; j < 19; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 검토 시작
        loop:
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                // 돌이 놓아져 있는 경우 탐색 진행
                if(graph[i][j] != 0) {
                    start_x = i;
                    start_y = j;
                    color = graph[i][j];
                    // 8개의 방향으로 탐색 진행
                    for(int k = 0; k < 8; k+=2) {
                        block_cnt = 0;
                        for(int z = 0; z < 2; z++) {
                            dfs(i, j, 1 , k + z);
                        }
                        if(block_cnt == 6) {
                            result = color;
                            result_x = start_x;
                            result_y = start_y;
                            break loop;
                        }
                    }
                }
            }
        }
        // 답이 없는 경우
        if(result == 0) {
            System.out.println(result);
        }
        // 답이 있는 경우
        else {
            System.out.println(result);
            System.out.printf("%d %d\n", result_x + 1, result_y + 1);
        }

    }
}

