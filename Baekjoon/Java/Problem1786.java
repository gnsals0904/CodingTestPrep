package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [P5] 백준 1786 찾기
 * 메모리 : 50316 KB
 * 시간 : 420 ms
 * 코드 길이 : 1661 B
 * 아이디어 : 비교해야하는 문자열의 길이가 각각 100만 으로 완전탐색을 할 경우 시간초과가 나게 된다.
 *  KMP 알고리즘을 활용해서 풀어야 O(N + M) 으로 해결할 수 있다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/1786">
 */
public class Problem1786 {
    public static void main(String[] args) throws IOException {
        // 입력받기
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String T = br.readLine();
        String P = br.readLine();
        // 해당 문자열이 몇 번 등장했는지
        int count_result = 0;
        // 해당 문자열이 등장한 인덱스가 어디인지
        StringBuilder sb = new StringBuilder();
        // 실패 함수 테이블
        int[] fail_table = new int[P.length()];
        // 실패 함수 테이블 채우기
        int j = 0;
        for(int i = 1; i < P.length(); i++){
            while (j > 0 && P.charAt(i) != P.charAt(j)){
                j = fail_table[j - 1];
            }
            if(P.charAt(i) == P.charAt(j)){
                fail_table[i] = j + 1;
                j++;
            }
        }
        // KMP
        j = 0;
        for(int i = 0; i < T.length(); i++){
            while(j > 0 && T.charAt(i) != P.charAt(j)){
                j = fail_table[j - 1];
            }
            if(T.charAt(i) == P.charAt(j)){
                j++;
            }
            // 찾은 경우
            if(j == P.length()){
                count_result++;
                sb.append(i + 2 - j).append(" ");
                j = fail_table[j - 1];
            }
        }
        System.out.println(count_result);
        if(count_result != 0){
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
