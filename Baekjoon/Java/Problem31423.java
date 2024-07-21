import java.io.*;
import java.util.*;

public class Problem31423 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int N = Integer.parseInt(br.readLine());
        String[] s = new String[N + 1];
        int[] next = new int[N + 1];
        int[] tail = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            s[i] = br.readLine();
            next[i] = i;
            tail[i] = i;
        }

        int cur = -1;

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            next[tail[left]] = right;
            tail[left] = tail[right];
            cur = left;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(s[cur]);
            cur = next[cur];
        }

        System.out.println(sb);
    }
}
