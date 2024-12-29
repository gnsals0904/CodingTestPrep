package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1916 {
    static int N, M;
    static int start, end;
    static ArrayList<Edge>[] graph;
    static int[] dist;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, dist));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(e.dist != dist[e.to]) continue;
            for(Edge next : graph[e.to]){
                if(dist[next.to] > dist[e.to] + next.dist){
                    dist[next.to] = dist[e.to] + next.dist;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Edge implements Comparable<Edge>{
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
