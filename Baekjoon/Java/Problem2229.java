import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2229 {
    static int N;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = Math.abs(arr[1] - arr[0]);
        for(int i = 2; i < N; i++){
            int maxValue = arr[i];
            int minValue = arr[i];
            for(int j = i; j > 0; j--){
                maxValue = Math.max(maxValue, arr[j]);
                minValue = Math.min(minValue, arr[j]);
                dp[i] = Math.max(dp[i], dp[j - 1] + maxValue - minValue);
            }
        }
        System.out.println(dp[N - 1]);
    }
}
