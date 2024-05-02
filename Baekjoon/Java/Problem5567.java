package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem5567 {
	static int n, m;
	static boolean[] isUsed;
	static boolean[][] graph;
	static int result;
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		isUsed = new boolean[n + 1];
		graph = new boolean[n + 1][n + 1];
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		isUsed[1] = true;
		dfs(1, 0);
		
//		for(int i = 0; i < n+1; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}
		for(int i = 2; i < n+1; i++) {
			if(isUsed[i]) result++;
		}
//		System.out.println("\n--\n");
//		System.out.println(Arrays.toString(isUsed));
		System.out.println(result);
	}
	
    static void dfs(int k, int depth) {
        if (depth == 2) return;

        
        for (int i = 1; i < n + 1; i++) {
            if (i == k) continue;
            if (graph[k][i]) {
            	isUsed[i] = true;
                dfs(i, depth + 1);
            }
        }
    }
}
