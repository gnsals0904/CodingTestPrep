package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15812 {
    static int[][] vector = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] graph;
    static int[][] temp_graph;
    static boolean[][] visited;
    static int N;
    static int M;
    static int result = 401;
    static int temp_result = 0;
    static int[][] house = new int[400][2];
    static int house_num;
    static Queue<int[]> queue = new LinkedList<int[]>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String input;
        house_num = 0;
        graph = new int[N][M];
        temp_graph = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            input = br.readLine();
            for(int j = 0; j < M; j++){
                graph[i][j] = input.charAt(j) - '0';
                temp_graph[i][j] = input.charAt(j) - '0';
                visited[i][j] = false;
                // 집 위치, 개수 저장
                if(graph[i][j] == 1){
                    house[house_num][0] = i;
                    house[house_num][1] = j;
                    house_num++;
                }
            }
        }
        // bfs
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(graph[i][j] != 0){
                    continue;
                }
                for(int i1 = i; i1 < N; i1++){
                    for(int j1 = 0; j1 < M; j1++){
                        if(graph[i1][j1] != 0){
                            continue;
                        }
                        if(j1 <= j && i1 == i){
                            continue;
                        }
                        if(graph[i1][j1] == 0){
                            queue.add(new int[]{i, j});
                            queue.add(new int[]{i1, j1});
                            visited[i][j] = true;
                            visited[i1][j1] = true;
                            bfs();
                            temp_result = 0;
                            for(int k = 0; k < house_num; k++){
                                if(temp_graph[house[k][0]][house[k][1]] > temp_result){
                                    // 마을이 초토화 되는 시간
                                    temp_result = temp_graph[house[k][0]][house[k][1]];
                                }
                            }
                            // 최소값을 찾아야해
                            if(temp_result < result){
                                result = temp_result;
                            }
                            // 원본 배열 복사
                            for(int k = 0; k < graph.length; k++) {
                                temp_graph[k] = graph[k].clone();
                            }
                            // 방문 배열 초기화
                            visited = new boolean[N][M];
                        }
                    }

                }
            }
        }
        System.out.println(result);
    }



    // bfs
    public static void bfs(){
        while(queue.size() != 0){
            int[] temp_x_y = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp_x_y[0] + vector[i][0];
                int ny = temp_x_y[1] + vector[i][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }
                temp_graph[nx][ny] = temp_graph[temp_x_y[0]][temp_x_y[1]] + 1;
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}

