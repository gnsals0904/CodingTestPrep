package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11501 {
    static int T;
    static int N;
    static int[] nums;
    static long result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            nums = new int[N];
            for(int j = 0; j < N; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }
            int maxValue = nums[N - 1];
            for(int j = N - 1; j >= 0; j--){
                if(nums[j] <= maxValue) result += maxValue - nums[j];
                else maxValue = nums[j];
            }
            sb.append(result).append("\n");
            result = 0;
        }
        System.out.print(sb);
    }
}
