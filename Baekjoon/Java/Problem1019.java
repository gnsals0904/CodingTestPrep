package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [P5] BJ 1019 책 페이지
 * 메모리 : 11544 KB
 * 시간 : 76 ms
 * 코드 길이 : 1590 B
 * 아이디어 : 페이지가 등장하는 횟수에는 규칙이 있다 => 일반항으로 만든다
 * 일반항을 사용하기 위해서는 첫번째 자리와 끝 자리를 각각 0 과 9 로 맞추어주어야하고
 * 맞추는 과정에서 발생하는 페이지들은 따로 세어준다.
 * 
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/1019">
 *
 */
public class Problem1019 {
	public static void main(String[] args) throws IOException {
		// 입력받기
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		// 책 페이지 저장 배열
		long[] pages_num = new long[10];
		Arrays.fill(pages_num, 0);
		// 자리수
		int digit = 1;
		// 시작 페이지
		int start = 1;
		// 시작 페이지가 끝 페이지보다 작은 경우만 반복
		while(start <= N) {
			// N의 끝 자리를 9로 바꾸어 주기
			while(N % 10 != 9 && start <= N) {
				// 감소한 페이지만큼 세어주기
				int tempN = N;
				while(tempN > 0) {
					pages_num[tempN % 10] += digit;
					tempN /= 10;
				}
				N--;
			}
			// 마지막 페이지가 더 작으면 노노
			if(N < start) break;
			// 시작페이지 보정하기
			while(start % 10 != 0 && start <= N){
				// 감소한 페이지만큼 세어주기
				int tempStart = start;
				while(tempStart > 0) {
					pages_num[tempStart % 10] += digit;
					tempStart /= 10;
				}
				start++;
			}
			// 다음 자리 확인
			start /= 10;
			N /= 10;
			// 일반항 적용
			for(int i = 0; i < 10; i++) {
				pages_num[i] += (N - start + 1) * digit;
			}
			// 다음 자리로
			digit *= 10;
		}
		StringBuilder sb = new StringBuilder();
		for(long result : pages_num) {
			sb.append(result).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
