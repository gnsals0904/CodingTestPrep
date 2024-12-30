package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1504 {
    static int N, E;
    static ArrayList<Edge>[] graph;
    static int[] dist;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, dist));
            graph[to].add(new Edge(from, dist));
        }
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        dijkstra(u);
        int uToStart = dist[1];
        int uToEnd = dist[N];
        int uToV = dist[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(v);
        int vToU = dist[u];
        int vToStart = dist[1];
        int vToEnd = dist[N];
        if(vToU != uToV || vToU == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        if(uToStart == Integer.MAX_VALUE || vToEnd == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        if(vToStart == Integer.MAX_VALUE || uToEnd == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        int min1 = uToStart + uToV + vToEnd;
        int min2 = vToStart + uToV + uToEnd;
        System.out.println(Math.min(min1, min2));
    }

    static void dijkstra(int idx){
        dist[idx] = 0;
        pq.add(new Edge(idx, 0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(dist[e.to] != e.dist) continue;
            for(Edge next : graph[e.to]){
                int ndist = e.dist + next.dist;
                if(dist[next.to] > ndist){
                    dist[next.to] = ndist;
                    pq.add(new Edge(next.to, ndist));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int dist;

        public Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}
