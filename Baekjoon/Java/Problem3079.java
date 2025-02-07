package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3079 {
    static int N, M;
    static int[] K;
    static int MAX_TIME;
    static long result = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = new int[N];
        for(int i = 0; i < N; i++){
            K[i] = Integer.parseInt(br.readLine());
            MAX_TIME = Math.max(MAX_TIME, K[i]);
        }
        long left = 0;
        long right = (long) MAX_TIME * M;
        while(left <= right){
            long mid = (left + right) / 2;
            long r = howMany(mid);
            if(r < M){
                left = mid + 1;
            }
            else {
                result = Math.min(result, mid);
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    static long howMany(long mid){
        long temp = 0;
        for(int i = 0; i < N; i++){
            temp += mid / K[i];
            if(temp > M){
                return temp;
            }
        }
        return temp;
    }
}
