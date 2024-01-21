package com.ssafy.algo03;

import java.util.Scanner;
/**
 * [B3] 백준 2446 별 찍기 - 9
 * 메모리 : 17852KB
 * 시간 : 220ms
 * 코드 길이 : 872B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2446">
 */

public class Problem2446 {
    public static void main(String[] args) {
        // 입력받을 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        // N을 입력받고
        int N = sc.nextInt();
        // 스트링 빌더 생성
        StringBuilder stringBuilder = new StringBuilder();
        // 규칙에 맞게 공백과 별을 쌓아줌
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                stringBuilder.append(" ");
            }
            for(int j = 0; j < 2 * N - 1 - (2 * i); j++){
                stringBuilder.append("*");
            }
            stringBuilder.append("\n");
        }
        for(int i = 1; i < N; i++){
            for(int j = 0; j < N - 1 - i; j++){
                stringBuilder.append(" ");
            }
            for(int j = 0; j < i * 2 + 1; j++){
                stringBuilder.append("*");
            }
            stringBuilder.append("\n");
        }
        // 출력
        System.out.println(stringBuilder);
    }
}
