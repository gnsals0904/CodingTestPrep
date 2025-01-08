package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem21939 {
    static int N, M;
    static TreeSet<Problem> problems = new TreeSet<>();
    static HashMap<Integer, Integer> problemsInfo = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            addProblem(P, L);
        }
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("add")) addProblem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else if(input.equals("solved")) solved(Integer.parseInt(st.nextToken()));
            else {
                sb.append(recommend(Integer.parseInt(st.nextToken()))).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void solved(int n){
        int diff = problemsInfo.get(n);
        problems.remove(new Problem(n, diff));
        problemsInfo.remove(n);
    }

    static int recommend(int n){
        if(n == 1){
            return problems.last().num;
        }
        return problems.first().num;
    }

    static void addProblem(int p, int l){
        if(problemsInfo.containsKey(p)){
            int diff = problemsInfo.get(p);
            problems.remove(new Problem(p, diff));
        }
        problemsInfo.put(p, l);
        problems.add(new Problem(p, l));
    }

    static class Problem implements Comparable<Problem>{
        int num;
        int diff;

        Problem(int num, int diff){
            this.num = num;
            this.diff = diff;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.diff != o.diff) {
                return this.diff - o.diff;
            }
            return this.num - o.num;
        }
    }
}
