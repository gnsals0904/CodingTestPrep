package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [G4] 백준 1759 암호만들기
 * 메모리 : 15084 KB
 * 시간 : 120 ms
 * 코드 길이 : 3538 B
 * 아이디어 : dfs 를 활용하여 재귀 탐색을 해서, 조건에 맞게 모든 경우를 뽑아주면 되지 않을까?
 * 모음이 없다거나, 자음이 1개이하면 그 경우는 제외해주면 될것같다
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/1759">
 */
public class Problem1759 {
    // 내가 찾는 암호의 길이
    static int L;
    // 가능성 있는 알파벳의 개수
    static int C; // 알파벳의 정보
    static char[] arr;
    // 총 결과가 담길 스트링 빌더
    static StringBuilder sb = new StringBuilder();
    // 하나의 결과가 담길 ArrayList
    static ArrayList<Character> temp_sb = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 내가 찾는 암호의 길이와 가능성 있는 알파벳의 개수를 입력받는다
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // char 배열로 변환 시켜준다.
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        // 오름차순으로 찾아야하므로 정렬해준다.
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        // 재귀 탐색 진행
        dfs(0, 0, false, 0);
        System.out.print(sb);
    }

    // start 는 해당 위치부터 탐색하겠다는 의미이고
    // depth 는 몇개를 골랐는지를 나타낸다.
    // use_vowel 은 모음을 고르면 true 가 된다
    // use_con은 고른 자음의 개수를 의미한다.
    static void dfs(int start, int depth, boolean use_vowel, int use_con) {
        // 내가 찾는 암호를 다 골랐다면
        if (depth == L) {
            // System.out.println("temp : " + temp_sb);
            // 조건에 맞다면 결과를 넣는다
            if (use_vowel && use_con > 1) {
                // System.out.println("이건 맞지 " + temp_sb);
                for (int i = 0; i < depth; i++) {
                    sb.append(temp_sb.get(i));
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            // System.out.println("i, temp : " + " " + temp_sb);
            // 알파벳 하나를 고르고
            temp_sb.add(arr[i]);
            // 모음을 골랐다면
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                use_vowel = true;
            }
            // 자음을 골랐다면
            else {
                use_con++;
            }
            // 다음 알파벳 고르기
            dfs(i + 1, depth + 1, use_vowel, use_con);
            // 원상복구 해준다
            // 자음을 골랐었다면
            char c = temp_sb.get(temp_sb.size() - 1);
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                use_con--;
            }
            // 방금 고른 알파벳을 빼준다.
            temp_sb.remove(temp_sb.size() - 1);
            // 지금까지 고른 것들에 모음이 없다면
            boolean flag = false;
            for (char c1 : temp_sb) {
                if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                    flag = true;
                }
            }
            // 바꾸어준다
            use_vowel = flag;
        }
    }
}

