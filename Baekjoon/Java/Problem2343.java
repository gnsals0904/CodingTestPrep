package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2343 {
    static int N, K;
    static int[] lectures;
    static int MAX_LENGTH = 10_000 * 100_000 + 1;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = MAX_LENGTH;
        while(start <= end){
            int mid = (start + end) / 2;
            Result r = isPossible(mid);
            if(r.isPossible){
                result = Math.min(result, r.maxResult);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(result);
    }

    static Result isPossible(int mid){
        int cnt = 1;
        int temp = 0;
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            if (lectures[i] > mid) {
                return new Result(false, cnt, max);
            }
            if (temp + lectures[i] > mid) {
                cnt++;
                max = Math.max(max, temp);
                temp = lectures[i];
            } else {
                temp += lectures[i];
            }
        }
        if(cnt <= K){
            max = Math.max(max, temp);
            return new Result(true, cnt, max);
        }
        return new Result(false, cnt, max);
    }

    static class Result{
        boolean isPossible;
        int howMany;
        int maxResult;

        Result(boolean possible, int howMany, int maxResult){
            this.isPossible = possible;
            this.howMany = howMany;
            this.maxResult = maxResult;
        }
    }
}
