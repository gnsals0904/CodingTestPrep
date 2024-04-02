package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [G2] BJ 2749 피보나치 수 3
 * 메모리 : 11596 KB
 * 시간 : 88 ms
 * 코드 길이 : 868 B
 * 아이디어 : 피보나치 수는 F(n+1) = F(n) + F(n-1) 이고 여기에서 모듈러 연산의 분배법칙을 적용하면
 * F(n+1) % m = (F(n) % m + F(n-1) % m) % m 이다.
 * 0 과 1 이 나오면, 주기를 찾은것이니 거기서 탈출하면 된다.
 * n > 2라면, k(10^n) = 15×10^(n-1) 인 성질을 활용한다.
 * 활용하면 K(10^6) = 15*10^5의 주기를 갖는다.
 * 이 주기를 활용하면 큰 값이 오더라도 모듈러 연산을 활용해 출력하면 된다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2749">
 *
 */
public class Problem2749 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        // n 값 받기
        long n = Long.parseLong(br.readLine());
        long period = 1500000;
        // n 값을 모듈러연산을 통해 작게 만든다 => qeury까지만 구하면 된다. 어차피 반복되니까
        long query = n % period;
		// 피보나치를 모듈러 연산을 진행하면서 구한다
		int num1 = 0;
		int num2 = 1;
		int count = 0;
		do {
			int next = (num1 + num2) % 1000000;
			num1 = num2;
			num2 = next;
			count++;
		}
		// 주기를 찾으면 그만둔다
		while(!(count == query));
		System.out.println(num1);
    }
}
