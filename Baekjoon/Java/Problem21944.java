package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem21944 {
    static int N, M;
    static ArrayList<TreeSet<Problem>> problemsWIthAlgo = new ArrayList<>();
    static TreeSet<Problem> allProblems = new TreeSet<>();
    static int[] algoIdx = new int[101];
    static HashMap<Integer, Problem> problemInfo = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(algoIdx, -1);
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            add(P, L, G);
        }
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("recommend")){
                sb.append(recommend1(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
            } else if(input.equals("recommend2")){
                sb.append(recommend2(Integer.parseInt(st.nextToken()))).append("\n");
            } else if(input.equals("recommend3")){
                sb.append(recommend3(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
            } else if(input.equals("add")){
                add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else if(input.equals("solved")){
                solved(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.print(sb);
    }

    static int recommend1(int g, int x){
        int idx = algoIdx[g];
        if(x == 1){
            return problemsWIthAlgo.get(idx).last().idx;
        }
        return problemsWIthAlgo.get(idx).first().idx;
    }

    static int recommend2(int x){
        if(x == 1){
            return allProblems.last().idx;
        }
        return allProblems.first().idx;
    }

    static int recommend3(int x, int l){
        if(x == 1){
            Problem temp = allProblems.ceiling(new Problem(0, l, 0));
            if(temp == null) return -1;
            return temp.idx;
        }
        Problem temp = allProblems.floor(new Problem(0, l, 0));
        if(temp == null) return -1;
        return temp.idx;
    }

    static void solved(int p){
        Problem temp = problemInfo.get(p);
        int idx = algoIdx[temp.algo];
        problemsWIthAlgo.get(idx).remove(temp);
        allProblems.remove(temp);
    }

    static void add(int p, int l, int g){
        int idx = algoIdx[g];
        if(problemInfo.containsKey(p)){
            solved(p);
        }
        Problem problem = new Problem(p, l, g);
        if(idx == -1){
            idx = problemsWIthAlgo.size();
            problemsWIthAlgo.add(new TreeSet<>());
            algoIdx[g] = idx;
            problemsWIthAlgo.get(idx).add(problem);
            allProblems.add(problem);
            problemInfo.put(p, problem);
            return;
        }
        problemsWIthAlgo.get(idx).add(problem);
        allProblems.add(problem);
        problemInfo.put(p, problem);
    }

    static class Problem implements Comparable<Problem>{
        int idx;
        int algo;
        int diff;

        public Problem(int idx, int diff, int algo){
            this.idx = idx;
            this.algo = algo;
            this.diff = diff;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.diff == o.diff){
                return this.idx - o.idx;
            }
            return this.diff - o.diff;
        }
    }
}
