package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem20183 {
    static int N, M, startNode, endNode;
    static long money;
    static ArrayList<Edge>[] graph;
    static long[] dist;
    static final long MAX_DIST = 100_000L * 1_000_000_000 + 1;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());
        money = Long.parseLong(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new long[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }
        long left = 0;
        long right = 1_000_000_000L;
        long mid = -1L;
        long answer = -1L;
        while(left <= right){
            mid = (right + left) / 2;
            if(dijkstra(mid)){
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        if(left == 0){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    static boolean dijkstra(long maxCost) {
        pq.clear();
        Arrays.fill(dist, MAX_DIST);
        dist[startNode] = 0;
        pq.add(new Edge(startNode, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if(e.dist > money) continue;
            if(dist[e.to] < e.dist) continue;
            if(e.to == endNode){
                return true;
            }
            for(Edge next : graph[e.to]) {
                long newDist = e.dist + next.dist;
                if(dist[next.to] > newDist && money >= newDist && maxCost >= next.dist){
                    dist[next.to] = newDist;
                    pq.add(new Edge(next.to, newDist));
                }
            }
        }
        return false;
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

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", dist=" + dist +
                    '}';
        }
    }
}
