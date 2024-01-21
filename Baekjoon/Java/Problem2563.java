package com.ssafy.algo03;

import java.util.Scanner;

/**
 * [S5] 백준 2563 색종이
 * 메모리 : 17780KB
 * 시간 : 224ms
 * 코드 길이 : 784B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2563">
 */
public class Problem2563 {
    public static void main(String[] args) throws Exception {
        // 도화지의 크기가 100이므로 100만큼 2차원 배열 선언
        int[][] arr = new int[100][100];
        Scanner sc = new Scanner(System.in);
        // n 을 입력받고
        int n = sc.nextInt();
        // n 개 만큼 붙일 색종이의 왼쪽아래 좌표를 입력받음
        for (int i = 0; i < n; i++) {
            // 왼쪽 아래 좌표부터 10의 크기이므로 해당 좌표마다 1을 넣어줌
            int y = sc.nextInt();
            int x = sc.nextInt();
            for (int i_y = 0; i_y < 10; i_y++) {
                for (int j_x = 0; j_x < 10; j_x++) {
                    arr[x + j_x][y + i_y] = 1;
                }
            }
        }
        // 결과를 담을 변수 선언
        int result = 0;
        // 전체 도화지를 돌면서 1(색종이 붙여진 위치의 좌표 값)의 개수를 세면 답이다.
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
