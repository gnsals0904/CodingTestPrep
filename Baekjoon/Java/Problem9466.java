import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9466 {
    static int T, n;
    static int[] graph;
    static int[] visited;
    static boolean[] group;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n + 1];
            visited = new int[n + 1];
            group = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (!group[i]) {
                    result++;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    static int dfs(int now) {
        visited[now] = 1;
        int next = graph[now];
        int cycleStart = -1;

        if (visited[next] == 0) {
            cycleStart = dfs(next);
        } else if (visited[next] == 1) {
            cycleStart = next;
        } else {
            cycleStart = -1;
        }

        if (cycleStart != -1) {
            group[now] = true;
            if (now == cycleStart) {
                cycleStart = -1;
            }
        }
        visited[now] = 2;
        return cycleStart;
    }
}
