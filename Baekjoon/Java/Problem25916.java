package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25916 {
    static int N, M;
    static int[] holes;
    static int result;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        holes = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            holes[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int tempValue = holes[right];
        if(tempValue <= M) result = tempValue;
        while(right < N){
            if(tempValue < M){
                right++;
                if(right >= N) break;
                tempValue += holes[right];
            }
            else {
                tempValue -= holes[left];
                left++;
            }
            if(tempValue <= M){
                result = Math.max(result, tempValue);
            }
        }
        System.out.println(result);
    }
}
