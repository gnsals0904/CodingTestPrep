package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem18223 {
    static int V, E, P;
    static ArrayList<Edge>[] graph;
    static int[] dist;
    static final int MAX_DIST = 5000 * 10000 + 1;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, dist));
            graph[to].add(new Edge(from, dist));
        }
        dist = new int[V + 1];
        Arrays.fill(dist, MAX_DIST);
        dijkstra(1);
        int minD = dist[V];
        Arrays.fill(dist, MAX_DIST);
        dijkstra(P);
        int minP = dist[1] + dist[V];
        if (minD == minP) {
            System.out.println("SAVE HIM");
            return;
        }
        System.out.println("GOOD BYE");
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
        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}
