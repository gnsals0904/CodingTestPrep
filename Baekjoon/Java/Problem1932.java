package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1932 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        // graph size
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 최댓값만 챙기면서 갱신
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i + 1; j++){
                // 처음 값
                if(j == 0){
                    graph[i][j] = graph[i - 1][j] + graph[i][j];
                }
                // 마지막 값
                else if(j == i){
                    graph[i][j] = graph[i - 1][j - 1] + graph[i][j];
                }
                // 중간에 있는 친구들
                else{
                    graph[i][j] = Math.max(graph[i - 1][j - 1], graph[i - 1][j]) + graph[i][j];
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            if(graph[N - 1][i] > result){
                result = graph[N - 1][i];
            }
        }
        System.out.println(result);
    }
}
