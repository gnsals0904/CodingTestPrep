import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[6][2];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            arr[temp2 - 1][temp1]++;
        }
        br.close();
        int count = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 2; j++){
                if(arr[i][j] % K > 0){
                    count += arr[i][j] / K + 1;
                }
                else{
                    count += arr[i][j] / K;
                }
            }
        }
        System.out.println(count);
    }
}
