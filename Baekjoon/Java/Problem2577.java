package com.ssafy.algo03;

import java.util.Scanner;

/**
 * [B2] 백준 2577 알파벳 개수
 * 메모리 : 17712KB
 * 시간 : 208ms
 * 코드 길이 : 932B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2577">
 */
public class Problem2577 {
    public static void main(String[] args) {
        // 입력 받을 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        // A B C를 입력받기
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // A와 B와 C는 각각 1000 으로 최댓값이 들어온다고 해도 10억으로 int 범위 안이니까 int 로 선언
        int sum = A * B * C;
        // 답을 출력할 배열 선언
        int[] arr = new int[10];
        // 10으로 나눈 나머지는 일의 자리의 수이다. 그리고 10으로 나눠주고 다음 10으로 나눈 나머지는 십의 자리의 수이다 이를 sum 이 0이될때까지 반복
        while(sum > 0){
            arr[sum % 10]++;
            sum = sum / 10;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(arr[i]);
        }
    }
}
