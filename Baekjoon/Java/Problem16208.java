package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem16208 {
    static int N;
    static ArrayList<Calc>[] calcs = new ArrayList[2];
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        calcs[0] = new ArrayList<Calc>();
        calcs[1] = new ArrayList<Calc>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            calcs[0].add(new Calc(Integer.parseInt(st.nextToken()), 0));
        }
        Collections.sort(calcs[0]);
        int turn = 0;
        while(N != 1){
            for(int i = 0; i < N / 2; i++){
                calcs[(turn + 1) % 2].add(new Calc(calcs[turn].get(i).sum + calcs[turn].get(N - i - 1).sum, calcs[turn].get(i).mul + calcs[turn].get(N - i - 1).mul + calcs[turn].get(i).sum * calcs[turn].get(N - i - 1).sum));
            }
            if(N % 2 != 0){
                calcs[(turn + 1) % 2].add(new Calc(calcs[turn].get(N/2).sum, calcs[turn].get(N/2).mul));
            }
            calcs[turn].clear();
            Collections.sort(calcs[(turn + 1) % 2]);
            turn = (turn + 1) % 2;
            N = N / 2 + (N % 2);
        }
        System.out.println(calcs[turn].get(0).mul);

    }

    static class Calc implements Comparable<Calc>{
        long sum;
        long mul;
        Calc(long sum, long mul){
            this.sum = sum;
            this.mul = mul;
        }

        @Override
        public int compareTo(Calc o) {
            return (int) (this.sum - o.sum);
        }

    }
}
