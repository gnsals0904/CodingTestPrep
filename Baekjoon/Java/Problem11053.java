package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11053 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] lis = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			lis[i] = 0;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i] <= lis[j]) {
					lis[j] = arr[i];
					break;
				}
				else if (lis[j] == 0) {
					lis[j] = arr[i];
					break;
				}
			}
		}
		int max_len = 0;
		for(int i = 0; i < N; i++) {
			if(lis[i] == 0) {
				max_len = i;
				break;
			}
		}
		System.out.println(max_len);
	}
}
