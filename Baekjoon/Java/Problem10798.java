package com.ssafy.algo03;

import java.util.Scanner;

/**
 * [B1] 백준 10798 세로읽기
 * 메모리 : 17784KB
 * 시간 : 208ms
 * 코드 길이 : 908B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/10798">
 */
public class Problem10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력은 다섯줄이 들어오므로 5개의 스트링배열 생성
        String[] arr = new String[5];
        // 가장 긴 스트링의 길이를 저장할 변수 선언
        int max_len = 0;
        // 입력을 받으면서 가장 긴 스트링의 길이를 저장한다
        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextLine();
            if(arr[i].length() > max_len) {
                max_len = arr[i].length();
            }
        }
        // 5줄을 돌면서 스트링의 길이를 모두 맞춰주기위해서 공백을 추가해준다.
        for(int i = 0; i < 5; i++){
            int temp = arr[i].length();
            if(temp < max_len){
                for(int j = 0; j < max_len - temp; j++) {
                    arr[i] = arr[i] + " ";
                }
            }
        }
        // 위에서 5개의 스트링의 길이를 모두 맞춰주었으니 세로로 값을 출력하면 된다. 단, 공백은 건너뛴다.
        for(int i = 0; i < max_len; i++){
            for(int j = 0; j < 5; j++){
                char r = arr[j].charAt(i);
                // 공백은 넘어가고
                if(r == ' '){
                    continue;
                }
                // 공백이 아니면 출력
                System.out.print(r);
            }
        }
    }
}
