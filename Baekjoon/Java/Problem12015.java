package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G2] BJ 12015 가장 긴 증가하는 부분 수열 2
 * 메모리 : 125,208 KB
 * 시간 : 472 ms
 * 코드 길이 : 1353 B
 * 아이디어 : 규칙에 맞게 DP 배열을 채워준다. DP 테이블의 i 번째 요소는 LIS 구성의 마지막으로 하는 최장길이임에 주의한다.
 * 이진탐색을 수행해서 최대한 시간 복잡도를 줄인다. lower bound로 탐색한다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/12015">
 *
 */

public class Problem12015 {
	static int[] arr;
	static int[] dp;
	static int N, point, end_p;
	public static void main(String[] args) throws IOException {
		// 입력을 받는다.
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		N = Integer.parseInt(br.readLine());
		// dp 배열의 길이 == 가장 긴 증가하는 부분 수열
		end_p = 0;
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			// arr 입력 받는다.
			arr[i] = Integer.parseInt(st.nextToken());
			// 처음 들어오는 값은 무조건 맨 앞에 넣기
			if(i == 0) {
				dp[0] = arr[0];
				end_p++;
			}
			else {
				// 맨 끝 값보다 지금 넣으려는 값이 크면 맨 뒤에 넣는다
				if(dp[end_p - 1] < arr[i]) {
					dp[end_p] = arr[i];
					end_p++;
				}
				else {
					// 그게 아니면 이진탐색 수행
					int idx = b_search(arr[i]);
					dp[idx] = arr[i];
				}
			}
		}
		System.out.println(end_p);
	}
	
	// lower bound는 데이터내 특정 K값보다 같거나 큰값이 처음 나오는 위치를 리턴해주고
	// upper bound 는 K값보다 처음으로 큰 값이 나오는 위치를 리턴
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
