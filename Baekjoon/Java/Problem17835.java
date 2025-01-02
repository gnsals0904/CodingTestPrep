package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem17835 {
    static int N, M, K;
    static ArrayList<Edge>[] graph;
    static long[] dist;
    static final long MAX_DIST = 100000L * 100000 + 1;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dist = new long[N + 1];
        Arrays.fill(dist, MAX_DIST);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[to].add(new Edge(from, dist));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int interviewSpot = Integer.parseInt(st.nextToken());
            dist[interviewSpot] = 0;
            pq.add(new Edge(interviewSpot, 0));
        }
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(e.dist != dist[e.to]) continue;
            for(Edge next : graph[e.to]){
                long ndist = next.dist + e.dist;
                if(dist[next.to] > ndist){
                    dist[next.to] = ndist;
                    pq.add(new Edge(next.to, ndist));
                }
            }
        }
        long maxDist = 0;
        int maxDistIdx = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] > maxDist){
                maxDist = dist[i];
                maxDistIdx = i;
            }
        }
        System.out.println(maxDistIdx);
        System.out.println(maxDist);
    }

    static class Edge implements Comparable<Edge> {
        int to;
        long dist;
        public Edge(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.dist, o.dist);
        }
    }
}
