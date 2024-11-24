package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem1949 {
    static int N;
    static int[] town;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static int result;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        town = new int[N + 1];
        StringTokenizer st;
        nodes = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++){
            nodes[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            town[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            nodes[to].add(from);
            nodes[from].add(to);
        }
        dp = new int[N + 1][2];
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int idx){
        visited[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = town[idx];

        for(int i = 0; i < nodes[idx].size(); i++){
            int nextIdx = nodes[idx].get(i);
            if(visited[nextIdx]) continue;
            dfs(nextIdx);

            dp[idx][0] += Math.max(dp[nextIdx][0], dp[nextIdx][1]);
            dp[idx][1] += dp[nextIdx][0];
        }
    }

    static class Node{
        int to;
        int from;
        Node(int to, int from){
            this.to = to;
            this.from = from;
        }
    }
}
