package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2596 {
    static String[] find = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int N = Integer.parseInt(br.readLine());
        String in = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 6 * N; i += 6){
            String substr = in.substring(i, i + 6);
            int idx = -1;
            // ABCDEFGH 탐색
            for(int j = 0; j < 8; j++){
                int count = 0;
                for(int k = 0; k < 6; k++){
                    if(substr.charAt(k) == find[j].charAt(k)) count++;
                }
                // 5글자 동일하면 가능성 있음
                if(count == 5){
                    idx = j;
                }
                // 완전 동일하면 더 탐색 x
                else if(count == 6){
                    idx = j;
                    break;
                }
            }
            // idx 가 그대로 -1 이면 못알아본 경우
            if(idx == -1){
                System.out.println(i/6 + 1);
                return;
            }
            sb.append((char) (idx + 'A'));
        }

        System.out.println(sb);
    }
}
