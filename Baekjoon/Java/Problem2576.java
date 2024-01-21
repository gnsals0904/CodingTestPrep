package com.ssafy.algo03;

import java.util.Scanner;

/**
 * [B3] 백준 2446 별 찍기 - 9
 * 메모리 : 17576KB
 * 시간 : 212ms
 * 코드 길이 : 935B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2576">
 */
public class Problem2576 {
    public static void main(String[] args) {
        // 입력받을 스캐너 객체
        Scanner sc = new Scanner(System.in);
        // 홀수의 합을 담을 변수
        int sum = 0;
        // 홀수들 중 최솟값 담을 변수
        int min = 101;
        // 7번 입력 받고
        for(int i = 0; i < 7; i++){
            int a = sc.nextInt();
            // 홀수이면
            if(a % 2 == 1){
                // 더하고
                sum += a;
                // 지금 최솟값보다 입력받은 수가 더 작으면 갱신
                if(min > a){
                    min = a;
                }
            }
        }
        // 합이 0 그대로면 홀수가 없는것
        if(sum == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
