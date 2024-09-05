package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11725 {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] parents;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        parents = new int[N];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            graph[from].add(to);
            graph[to].add(from);
        }
        queue.add(0);
        visited[0] = true;
        bfs();
        showAns();
    }

    static void bfs(){
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int nextCur : graph[cur]){
                if(!visited[nextCur]){
                    visited[nextCur] = true;
                    parents[nextCur] = cur;
                    queue.add(nextCur);
                }
            }
        }
    }

    static void showAns(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N; i++){
            sb.append(parents[i] + 1).append("\n");
        }
        System.out.print(sb);
    }
}
