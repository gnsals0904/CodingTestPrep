package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1032 {
    static int N;
    static char[][] inputs;
    static char[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        inputs = new char[N][temp.length()];
        result = new char[temp.length()];
        result = temp.toCharArray();
        inputs[0] = temp.toCharArray();
        for(int i = 1; i < N; i++) {
            inputs[i] = br.readLine().toCharArray();
            for(int j = 0; j < inputs[i].length; j++) {
                if(inputs[i][j] != result[j]) {
                    if(result[j] == '?') continue;
                    result[j] = '?';
                }
            }
        }
        System.out.println(result);
    }
}
