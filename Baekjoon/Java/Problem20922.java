package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem20922 {
    static Queue<Integer> queue = new LinkedList<>();
    static int N, K;
    static int result = Integer.MIN_VALUE;
    static int[] numCount = new int[100001];
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int nowNumber = Integer.parseInt(st.nextToken());
            numCount[nowNumber]++;
            queue.add(nowNumber);
            if(numCount[nowNumber] > K){
                findNum(nowNumber);
            }
            result = Math.max(result, queue.size());
        }
        System.out.println(result);
    }

    static void findNum(int n){
        while(!queue.isEmpty()){
            int pollNum = queue.poll();
            numCount[pollNum]--;
            if (pollNum == n){
                return;
            }
        }
    }
}
