package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1261 {
    static int N, M;
    static char[][] graph;
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        dist = new int[N][M];
        for(int i = 0; i < N; i++){
            graph[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new Element(0,0,0));
        while(!pq.isEmpty()){
            Element e = pq.poll();
            if(dist[e.x][e.y] != e.dist) continue;
            for(int[] v : vector){
                int nx = e.x + v[0];
                int ny = e.y + v[1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                int ndist = e.dist + graph[nx][ny] - '0';
                if(dist[nx][ny] > ndist){
                    dist[nx][ny] = ndist;
                    pq.add(new Element(nx,ny,ndist));
                }
            }
        }
        System.out.println(dist[N-1][M-1]);
    }

    public static class Element implements Comparable<Element>{
        int x;
        int y;
        int dist;
        public Element(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Element o) {
            return this.dist - o.dist;
        }
    }
}
