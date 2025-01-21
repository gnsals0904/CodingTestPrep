package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1976 {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N];
        setParents();
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                if(Integer.parseInt(st.nextToken()) == 1) union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int p = find(Integer.parseInt(st.nextToken()) - 1);
        for(int i = 0; i < M - 1; i++){
            int now = find(Integer.parseInt(st.nextToken()) - 1);
            if(p != now){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void union(int a, int b){
        int parentsA = find(a);
        int parentsB = find(b);
        if(parentsA != parentsB){
            parents[parentsA] = parentsB;
        }
    }

    static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    static void setParents(){
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }
    }
}
