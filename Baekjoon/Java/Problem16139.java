import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16139 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String input = br.readLine();
        int[][] dp = new int[input.length()][26];
        for(int i = 0; i < input.length(); i++){
            int idx = input.charAt(i) - 'a';
            dp[i][idx] = 1;
        }
        for(int i = 1; i < input.length(); i++){
            for(int j = 0; j < 26; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j];
            }
        }
        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start == 0){
                sb.append(dp[end][idx]).append("\n");
            }
            else{
                sb.append(dp[end][idx] - dp[start - 1][idx]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
