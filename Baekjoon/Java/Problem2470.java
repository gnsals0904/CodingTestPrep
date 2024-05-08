package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2470 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int result = Integer.MAX_VALUE;
        int result1 = 0, result2 = 0;
        int start = 0;
        int end = N - 1;
        while(start < end) {
        	int sum = arr[start] + arr[end];
        	int absSum = Math.abs(sum);
            if (absSum < result) {
                result = absSum;
                result1 = arr[start];
                result2 = arr[end];
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(result1 + " " + result2);
	}
}
