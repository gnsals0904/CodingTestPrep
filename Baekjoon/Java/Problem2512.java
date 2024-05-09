package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2512 {
	public static void main(String[] args) throws Exception{
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		int sum_arr = 0;
		int max_v = Integer.MIN_VALUE;
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum_arr += arr[i];
			max_v = Math.max(max_v, arr[i]);
		}
		Arrays.sort(arr);
		int max = Integer.parseInt(br.readLine());
		int remainMoney = max;
		int result = 0;
		for(int i = 0; i < N; i++) {
			int remainNum = N - i;
			int temp = remainMoney / remainNum;
//			System.out.println("rMoney : " + remainMoney);
//			System.out.println("rNum : " + remainNum);
//			System.out.println(temp);
			// 줄수있으면
			if(arr[i] <= temp) {
				remainMoney -= arr[i];
				result = arr[i];
			}
			// 못주면
			else {
				result = remainMoney / remainNum;
				System.out.println(result);
				return;
			}
		}
		System.out.println(result);
	}
}
