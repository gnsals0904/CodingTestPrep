class 네트워크 {
    static int N;
    static boolean[] visited;
    static int result;
    public int solution(int n, int[][] computers) {
        N = n;
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(computers, i);
            result++;
        }
        return result;
    }
    
    static void dfs(int[][] computers, int v){
        for(int i = 0; i < N; i++){
            if(computers[v][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(computers, i);
            }
        }
    }
}
