package com.ssafy.algo03;

import java.util.Scanner;
/**
 * [B3] 백준 2444 별 찍기 - 7
 * 메모리 : 17844KB
 * 시간 : 212ms
 * 코드 길이 : 885B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2444">
 */

public class Problem2444 {
    public static void main(String[] args) {
        // 입력받고
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 스트링빌더 생성
        StringBuilder stringBuilder = new StringBuilder();
        // 반복문을 돌면서 규칙에 맞게 공백과 별을 빌더에 쌓기
        for(int i = 0; i < N; i++){
            for(int j = i; j < N - 1; j++){
                stringBuilder.append(" ");
            }
            for(int j = 0; j < 2 * (i + 1) - 1; j++){
                stringBuilder.append("*");
            }
            stringBuilder.append("\n");
        }

        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < i + 1; j++){
                stringBuilder.append(" ");
            }
            for(int j = 0; j < (N - 1) * 2 - 1 -(2 * i); j++){
                stringBuilder.append("*");
            }
            stringBuilder.append("\n");
        }
        // 빌더에 쌓인 만큼 출력
        System.out.print(stringBuilder);
    }
}
