import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem12026 {
    static int N;
    static String inputs;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = br.readLine();
        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] != Integer.MAX_VALUE && canGo(inputs.charAt(j), inputs.charAt(i))){
                    dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
                }
            }
        }
        if (dp[N - 1] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[N-1]);
    }

    static boolean canGo(char from, char to){
        switch(from){
            case 'B' -> {
                return to == 'O';
            }
            case 'O' -> {
                return to == 'J';
            }
            case 'J' -> {
                return to == 'B';
            }
            default -> {
                return false;
            }
        }
    }
}
