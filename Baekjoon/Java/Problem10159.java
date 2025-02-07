package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem10159 {
    static int N, M;
    static ArrayList<Integer>[] moreWeightGraph;
    static ArrayList<Integer>[] lessWeightGraph;
    static boolean[] moreVisited;
    static boolean[] lessVisited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        moreWeightGraph = new ArrayList[N + 1];
        lessWeightGraph = new ArrayList[N + 1];
        moreVisited = new boolean[N + 1];
        lessVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            moreWeightGraph[i] = new ArrayList<>();
            lessWeightGraph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int more = Integer.parseInt(st.nextToken());
            int less = Integer.parseInt(st.nextToken());
            moreWeightGraph[less].add(more);
            lessWeightGraph[more].add(less);
        }
        for(int i = 1; i <= N; i++){
            sb.append(N - bfs(i)).append("\n");
            setVisited();
        }
        System.out.print(sb);
    }

    static int bfs(int startN){
        int r = 1;
        queue.add(startN);
        moreVisited[startN] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i : moreWeightGraph[cur]){
                if(!moreVisited[i]){
                    queue.add(i);
                    moreVisited[i] = true;
                    r++;
                }
            }
        }
        queue.add(startN);
        lessVisited[startN] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i : lessWeightGraph[cur]){
                if(!lessVisited[i]){
                    queue.add(i);
                    lessVisited[i] = true;
                    r++;
                }
            }
        }
        return r;
    }

    static void setVisited(){
        Arrays.fill(moreVisited, false);
        Arrays.fill(lessVisited, false);
    }
}
