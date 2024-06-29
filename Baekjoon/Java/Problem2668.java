package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2668 {
    static int N;
    static int[] inputs;
    static boolean[] canCycle;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        canCycle = new boolean[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < N; i++){
            dfs(i + 1, i + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N + 1; i++){
            if(canCycle[i]) result++;
        }
        sb.append(result).append("\n");
        for(int i = 0; i < N + 1; i++){
            if(canCycle[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int startV, int nextV){
        if(visited[nextV]){
            if(startV == nextV){
                for(int i = 0; i < N + 1; i++){
                    if(visited[i]) {
                        canCycle[i] = true;
                    }
                }
            }
            return;
        }
        visited[nextV] = true;
        dfs(startV, inputs[nextV - 1]);
        visited[nextV] = false;
    }


}
