package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11657 {
    static int N, M;
    static long[] dist;
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];
        edges = new Edge[M];
        Arrays.fill(dist, Long.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, value);
        }
        dist[1] = 0;
        for(int i = 0; i <= N; i++){
            for(int j = 0; j < M; j++){
                int from = edges[j].from;
                int to = edges[j].to;
                int cost = edges[j].cost;
                if(dist[from] != Long.MAX_VALUE && dist[to] > dist[from] + cost){
                    dist[to] = dist[from] + cost;
                    if(i == N){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++){
            if(dist[i] == Long.MAX_VALUE) dist[i] = -1;
            sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    static class Edge{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

}
