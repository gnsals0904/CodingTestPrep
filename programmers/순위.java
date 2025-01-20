class 순위 {
    static int N;
    static boolean[][] dist;
    public int solution(int n, int[][] results) {
        N = n;
        dist = new boolean[N+1][N+1];
        for(int[] r : results){
            dist[r[0]][r[1]] = true;
        }
        for(int k = 1; k < N + 1; k++){
            for(int i = 1; i < N + 1; i++){
                for(int j = 1; j < N + 1; j++){
                    if(dist[i][k] && dist[k][j]) dist[i][j] = true;
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < N+1; i++){
            if(canCalc(i)) ans++;
        }
        return ans;
    }
    
    static boolean canCalc(int n){
        int goN = 0;
        int comeN = 0;
        for(int i = 1; i < N + 1; i++){
            if(dist[n][i]) goN++;
            if(dist[i][n]) comeN++;
        }
        if((goN + comeN) == N - 1) return true;
        else return false;
    }
}
