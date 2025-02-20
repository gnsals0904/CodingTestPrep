package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Problem1865 {
    static int T, N, M, W;
    static int edgeNum;
    static int[] dist;
    static Edge[] edges;
    static int MAX_DIST = 2500*10000+1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            edgeNum = M * 2 + W;
            dist = new int[N + 1];
            Arrays.fill(dist, MAX_DIST);
            edges = new Edge[edgeNum];
            int cnt = 0;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[cnt++] = new Edge(from, to, weight);
                edges[cnt++] = new Edge(to, from, weight);
            }
            for(int i = 0; i < W; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken()) * -1;
                edges[cnt++] = new Edge(from, to, weight);
            }
            if(bellmanFord()){
                sb.append("NO\n");
            } else sb.append("YES\n");
        }
        System.out.print(sb);
    }

    static boolean bellmanFord(){
        dist[1] = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < edgeNum; j++){
                int from  = edges[j].from;
                int to = edges[j].to;
                int weight = edges[j].weight;
                if(dist[to] > dist[from] + weight){
                    dist[to] = dist[from] + weight;
                    if(i == N-1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
