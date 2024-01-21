package com.ssafy.algo03;

import java.util.Scanner;

/**
 * [B4] 백준 10808 알파벳 개수
 * 메모리 : 18368KB
 * 시간 : 232ms
 * 코드 길이 : 973B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/10808">
 */
public class Problem10808 {
    public static void main(String[] args) {
        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        // 스트링타입으로 입력받기
        String s = sc.nextLine();
        // 알파벳 26개만큼의 배열 생성 자동 0으로 초기화
        int[] arr = new int[26];
        // 스트링에서 하나씩 char 타입으로 빼서 a 만큼을 빼면 아스키코드값으로 순서대로 나오니 그대로 배열에 넣고 증가
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        // 출력 형식에 맞게 출력
        for(int i = 0; i < 25; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[25]);
    }
}
