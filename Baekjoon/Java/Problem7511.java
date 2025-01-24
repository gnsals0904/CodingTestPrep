package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7511 {
    static int T, t;
    static int N, K, M;
    static int[] parents;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        t = T;
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            parents = new int[N];
            setParent();
            K = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            M = Integer.parseInt(br.readLine());
            sb.append("Scenario ").append(t - T).append(":\n");
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                a = find(a);
                b = find(b);
                if(a == b) {
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void setParent() {
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) {
            return;
        }
        parents[b] = a;
    }

    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }
}
