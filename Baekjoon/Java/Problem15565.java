package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem15565 {
    static int N, K;
    static int[] dolls;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dolls = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int tempNum = 0;
        while(left < N && right < N) {
            if(dolls[right] == 1){
                tempNum++;
            }
            if (tempNum >= K) {
                while (dolls[left] != 1) {
                    left++;
                }
                result = Math.min(result, right - left + 1);
                left++;
                tempNum--;
            }
            right++;
        }
        if(result == Integer.MAX_VALUE){
            result = -1;
        }
        System.out.println(result);
    }
}
