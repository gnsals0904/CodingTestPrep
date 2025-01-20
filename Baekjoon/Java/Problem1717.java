package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1717 {
    static int N, M;
    static int[] uf;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        uf = new int[N + 1];
        for(int i = 0; i < N + 1; i++){
            uf[i] = i;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(o == 0){
                union(a, b);
            }
            else if(o == 1){
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            uf[rootA] = rootB;
        }
    }

    static int find(int u){
        if(uf[u] == u) return u;
        return uf[u] = find(uf[u]);
    }
}
