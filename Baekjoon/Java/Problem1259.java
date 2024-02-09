package com.ssafy.algo03;

import java.util.Scanner;
/**
 * [B1] 백준 1259 팰린드롬수
 * 메모리 : 17504KB
 * 시간 : 200ms
 * 코드 길이 : 652B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/1259">
 */
public class Problem1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 0 이나올때까지 루프
        while(true){
            String s = sc.nextLine();
            // 팰린드롬 수인지 아닌지 true false 로 체크하는 변수
            boolean flag = false;
            // 들어온 수가 0이면 그만해야하니 break
            if(s.equals("0")){
                break;
            }
            // 문자열 길이만큼 앞과 뒤를 서로 비교해서 다르면 no 출력하고 break
            for(int i = 0; i < s.length() / 2; i++){
                if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                    System.out.println("no");
                    flag = true;
                    break;
                }
            }
            // flag 를 true 로 바꾸지 않았으면 팰린드롬수이므로 yes
            if(!flag){
                System.out.println("yes");
            }
        }
    }
}
