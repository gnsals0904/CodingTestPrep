package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2417 {
    static long N;
    static long MAX_VALUE = (long) Math.pow(2, 32);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long start = 0;
        long end = MAX_VALUE;
        long result = 0;
        long mid = 0;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if (mid > 0 && mid > N / mid) {
                result = mid;
                end = mid - 1;
            } else {
                long sq = mid * mid;
                if (sq >= N) {
                    result = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        System.out.println(result);
    }
}
