import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1535 {
    static int N;
    static int[][] dp;
    static Some[] somes;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][100];
        somes = new Some[N];
        for(int i = 0; i < N; i++){
            somes[i] = new Some();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            somes[i].weight = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            somes[i].value = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < 100; j++){
                if(j >= somes[i - 1].weight){
                    dp[i][j] = Math.max(dp[i - 1][j - somes[i - 1].weight] + somes[i - 1].value, dp[i - 1][j]);
                }
                else dp[i][j] = dp[i - 1][j];
            }
        }
//        showDP();
        System.out.println(dp[N][99]);
    }


    // debug
    static void showDP(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N + 1; i++){
            for(int j = 0; j < 100; j++){
                sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static class Some{
        int weight;
        int value;
        Some(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
        Some(){
        };

        @Override
        public String toString() {
            return "Some{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }
}
