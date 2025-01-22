package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem4195 {
    static int T, F;
    static int[] parent;
    static int[] size;
    static HashMap<String, Integer> indexMap;
    static int idxCount;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            F = Integer.parseInt(br.readLine());
            parent = new int[F * 2 + 1];
            size = new int[F * 2 + 1];
            indexMap = new HashMap<>();
            idxCount = 0;
            for(int i = 0; i < F * 2 + 1; i++){
                parent[i] = i;
                size[i] = 1;
            }

            for(int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                int aIdx = getIndex(a);
                int bIdx = getIndex(b);

                union(aIdx, bIdx);

                int networkSize = size[parent[aIdx]];
                sb.append(networkSize).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int getIndex(String name) {
        if(!indexMap.containsKey(name)) {
            indexMap.put(name, idxCount++);
        }
        return indexMap.get(name);
    }

    static int find(int x){
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
            size[a] += size[b];
        }
    }
}
