package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5972 {
    static int N, M;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static int[] dist;
    static final int MAX_DIST = 50_000 * 1_000 + 1;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, MAX_DIST);
        for (int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from, dist));
        }
        dist[1] = 0;
        pq.add(new Element(1, 0));
        while (!pq.isEmpty()){
            Element e = pq.poll();
            int nowIdx = e.idx;
            int nowDist = e.dist;
            if(dist[nowIdx] != nowDist) continue;
            for(int i = 0; i < graph[nowIdx].size(); i++){
                int targetIdx = graph[nowIdx].get(i).to;
                int targetDist = graph[nowIdx].get(i).dist;
                int newDist = targetDist + nowDist;
                if(dist[targetIdx] > newDist){
                    dist[targetIdx] = newDist;
                    pq.add(new Element(targetIdx, dist[targetIdx]));
                }
            }
        }
        System.out.println(dist[N]);
    }

    static class Node {
        int to;
        int dist;
        Node(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }

    static class Element implements Comparable<Element>{
        int idx;
        int dist;

        Element(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Element o) {
            return this.dist - o.dist;
        }
    }
}
