package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1956 {
    static int MAX_DIST = 400*10000+1;
    static int V, E;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V+1][V+1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], MAX_DIST);
            dist[i][i] = MAX_DIST;
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[from][to] = weight;
        }

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                for(int k = 1; k <= V; k++){
                    if(dist[j][i] != 0 && dist[i][k] != 0){
                        if(dist[j][i] + dist[i][k] < dist[j][k]){
                            dist[j][k] = dist[j][i] + dist[i][k];
                        }
                    }
                }
            }
        }

        int result = MAX_DIST;
        for(int i = 1; i <= V; i++){
            result = Math.min(result, dist[i][i]);
        }
        if (result == MAX_DIST) System.out.println(-1);
        else System.out.println(result);

    }
}
