import java.util.*;
import java.io.*;

class 가장_먼_노드 {
    static int N;
    static int maxDist;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Set<Integer> longestVertex = new HashSet();
    static Queue<Integer> queue = new LinkedList();
    public int solution(int n, int[][] edge) {
        N = n;
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList();
        }
        for(int[] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        queue.add(1);
        visited[1] = true;
        int time = 0;
        int size = queue.size();
        while(!queue.isEmpty()){
            longestVertex.clear();
            for(int i = 0; i < size; i++){
                int a = queue.poll();
                longestVertex.add(a);
                for(int next : graph[a]){
                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                }
            }
            size = queue.size();
            time++;
        }
        return longestVertex.size();
    }
}
