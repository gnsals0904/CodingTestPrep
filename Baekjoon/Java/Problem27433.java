package com.ssafy.algo03;

import java.util.Scanner;

/**
 * [B5] 백준 27433 팩토리얼 2
 * 메모리 : 17624KB
 * 시간 : 204ms
 * 코드 길이 : 375B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/27433">
 */

public class Problem27433 {
    // 팩토리얼을 재귀로 호출할 함수
    public static long func(int n) {
        // n이 1보다 작으면 1의 값을 리턴한다. 0! 도 1이므로
        if (n <= 1) {
            return 1;
        }
        // n! 은 n * (n - 1)! 과 같다.
        return (n) * func(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N을 입력받고
        int N = sc.nextInt();
        // 20! 은 int 의 범위를 벗어나므로 long 으로 선언
        long result = func(N);
        // 답 출력
        System.out.println(result);
    }
}
