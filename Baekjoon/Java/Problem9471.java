package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S4] BJ 9471 피사노 주기
 * 메모리 : 13180 KB
 * 시간 : 104 ms
 * 코드 길이 : 902 B
 * 아이디어 : 피보나치 수는 F(n+1) = F(n) + F(n-1) 이고 여기에서 모듈러 연산의 분배법칙을 적용하면
 * F(n+1) % m = (F(n) % m + F(n-1) % m) % m 이다.
 * 0 과 1 이 나오면, 주기를 찾은것이니 거기서 탈출하면 된다.
 * 피보나치수의 특성상, 0과 1이 나오면 다음 수는 무조건 1이 나오니까 0과 1만 찾으면 된다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/12015">
 *
 */
public class Problem9471 {
	public static void main(String[] args) throws IOException {
		// 입력 받는다.
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		// test case 입력
		int P = Integer.parseInt(br.readLine());
		// 결과를 저장한다
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스를 진행한다
		for(int testcase = 1; testcase <= P; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// n과 m을 입력 받는다
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 피보나치를 모듈러 연산을 진행하면서 구한다
			int num1 = 0;
			int num2 = 1;
			int count = 0;
			do {
				int next = (num1 + num2) % M;
				num1 = num2;
				num2 = next;
				count++;
			}
			// 주기를 찾으면 그만둔다
			while(!(num1 == 0 && num2 == 1));
			sb.append(testcase).append(" ").append(count).append("\n");
		}
		System.out.print(sb);
	}
}
