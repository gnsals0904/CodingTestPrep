import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Problem1238 {
    static int N, M, X;
    static ArrayList<Edge>[] graph, reverseGraph;
    static final int MAX_DIST = 1000 * 10000 * 100 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, dist));
            reverseGraph[to].add(new Edge(from, dist));
        }

        int[] toX = dijkstra(graph, X);
        int[] fromX = dijkstra(reverseGraph, X);

        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            maxDist = Math.max(maxDist, toX[i] + fromX[i]);
        }

        System.out.println(maxDist);
    }

    static int[] dijkstra(ArrayList<Edge>[] graph, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX_DIST);
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (dist[e.to] < e.dist) continue;

            for (Edge next : graph[e.to]) {
                int ndist = e.dist + next.dist;
                if (dist[next.to] > ndist) {
                    dist[next.to] = ndist;
                    pq.add(new Edge(next.to, ndist));
                }
            }
        }
        return dist;
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
