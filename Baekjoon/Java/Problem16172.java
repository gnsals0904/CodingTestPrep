package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [B2] 백준 16172 나는 친구가 적다 (Large)
 * 메모리 : 18220 KB
 * 시간 : 188 ms
 * 코드 길이 : 1467 B
 * 아이디어 : 비교해야하는 문자열의 길이가 각각 20만 으로 완전탐색을 할 경우 시간초과가 나게 된다.
 * KMP 알고리즘을 활용해서 풀어야 O(N + M) 으로 해결할 수 있다.
 * 먼저, 숫자를 제거해준 다음 KMP 알고리즘을 활용한다
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/16172">
 *
 */
public class Problem16172 {
    public static void main(String[] args) throws IOException {
        // 입력받기
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String s = br.readLine();
        // s 내의 숫자 없애기
        char[] s_1 = new char[s.length()];
        int s_len = 0;
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                s_1[s_len] = s.charAt(i);
                s_len++;
            }
        }
        String p = br.readLine();
        int[] fail_table = new int[p.length()];
        // 실패 함수 채우기
        int j = 0;
        for(int i = 1; i < p.length(); i++){
            while(j > 0 && p.charAt(i) != p.charAt(j)){
                j = fail_table[j - 1];
            }
            if(p.charAt(i) == p.charAt(j)){
                fail_table[i] = j + 1;
                j++;
            }
        }
        // KMP
        j = 0;
        for(int i = 0; i < s_len; i++){
            while(j > 0 && s_1[i] != p.charAt(j)){
                j = fail_table[j - 1];
            }
            if(s_1[i] == p.charAt(j)){
                j++;
            }
            if(j == p.length()){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
