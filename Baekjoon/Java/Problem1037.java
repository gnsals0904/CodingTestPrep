package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1037 {
    static int N;
    static int[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        int max = 0;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, inputs[i]);
            min = Math.min(min, inputs[i]);
        }
        System.out.println(max*min);

    }
}
