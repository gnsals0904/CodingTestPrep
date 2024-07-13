package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem18222 {
    static long N;
    static long[] nums = new long[64];
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Long.parseLong(br.readLine());
        nums[0] = 1;
        for(int i = 1; i < 64; i++){
            nums[i] = nums[i - 1] * 2;
        }
        System.out.println(recur(N));
    }

    static int recur(long n){
        int k = -1;
        if(n == 1){
            return 0;
        }
        for(int i = 0; i < 63; i++){
            if(nums[i] <= n && n <= nums[i + 1]){
                k = recur(n - nums[i]);
                break;
            }
        }
        return 1 - k;

    }
}
