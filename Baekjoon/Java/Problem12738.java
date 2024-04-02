package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// lower bound는 데이터내 특정 K값보다 같거나 큰값이 처음 나오는 위치를 리턴해주고
// upper bound 는 K값보다 처음으로 큰 값이 나오는 위치를 리턴
public class Problem12738 {
	static int[] arr;
	static int[] dp;
	static int N, point, end_p;
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		N = Integer.parseInt(br.readLine());
		end_p = 0;
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 0) {
				dp[0] = arr[0];
				end_p++;
			}
			else {
				if(dp[end_p - 1] < arr[i]) {
					dp[end_p] = arr[i];
					end_p++;
				}
				else {
					int idx = b_search(arr[i]);
					dp[idx] = arr[i];
				}
			}
		}
		System.out.println(end_p);
	}
	
	// 이진탐색 lower bound
	public static int b_search(int num) {
		int start = 0;
		int end = end_p;
		int mid;
		while(start < end) {
			mid = (start + end) / 2;
			if(dp[mid] < num) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
		}
		return start;
	}
}
