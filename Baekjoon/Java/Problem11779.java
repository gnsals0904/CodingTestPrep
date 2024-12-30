package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem11779 {
    static int N, M;
    static int start, end;
    static ArrayList<Edge>[] graph;
    static int[] dist;
    static int[] path;
    static final int MAX_DIST = 1000 * 100_000 + 1;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, MAX_DIST);
        path = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, dist));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dist[start] = 0;
        path[start] = -1;
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if(dist[e.to] != e.dist) continue;
            for(Edge next : graph[e.to]) {
                int ndist = e.dist + next.dist;
                if(dist[next.to] > ndist){
                    dist[next.to] = ndist;
                    pq.add(new Edge(next.to, ndist));
                    path[next.to] = e.to;
                }
            }
        }
        System.out.println(dist[end]);
        int cnt = 1;
        Stack<Integer> paths = new Stack<>();
        paths.add(end);
        while(path[end] != -1){
            paths.add(path[end]);
            cnt++;
            end = path[end];
        }
        StringBuilder result = new StringBuilder();
        while(!paths.isEmpty()){
            result.append(paths.pop()).append(" ");
        }
        result.setLength(result.length() - 1);
        System.out.println(cnt);
        System.out.println(result);
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
