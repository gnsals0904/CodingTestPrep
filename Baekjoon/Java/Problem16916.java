package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [B2] 백준 16916 부분 문자열
 * 메모리 : 30320 KB
 * 시간 : 352 ms
 * 코드 길이 : 1237 B
 * 아이디어 : 비교해야하는 문자열의 길이가 각각 백만으로 완전탐색을 할 경우 시간초과가 나게 된다.
 * KMP 알고리즘을 활용해서 풀어야 O(N + M) 으로 해결할 수 있다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/16916">
 *
 */
public class Problem16916 {
    public static void main(String[] args) throws IOException {
        // 입력받기
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String s = br.readLine();
        String p = br.readLine();
        // 실패 함수 채우기
        int[] fail_table =  new int[p.length()];
        Arrays.fill(fail_table, 0);
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
        // KMP 시작
        j = 0;
        for(int i = 0; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != p.charAt(j)){
                j = fail_table[j - 1];
            }
            if(s.charAt(i) == p.charAt(j)){
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
