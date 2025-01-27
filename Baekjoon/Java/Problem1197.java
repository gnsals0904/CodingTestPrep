import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1197 {
    static int V, E;
    static int[] parents;
    static Edge[] edges;
    static long result;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        edges = new Edge[E];
        for(int i = 0; i < V + 1; i++) {
            parents[i] = i;
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(edges);
        for(int i = 0; i < E; i++){
            if(count == V-1) break;
            if(union(edges[i].from, edges[i].to)) {
                result += edges[i].weight;
                count++;
            }
        }
        System.out.println(result);
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parents[b] = a;
        return true;
    }

    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }
}
