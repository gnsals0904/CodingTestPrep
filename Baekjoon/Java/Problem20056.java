package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem20056 {
    static ArrayList<FireBall>[][] fireBallGraph;
    static Set<FireBall> fireBalls = new HashSet<>();
    static int N, M, K;
    static int[][] vector = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        fireBallGraph = new ArrayList[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                fireBallGraph[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBalls.add(new FireBall(x, y, m, s, d));
        }
        for(int i = 0; i < K; i++){
            move();
            separate();
        }
        // 정답 계산
        for(FireBall fireBall : fireBalls){
            result += fireBall.m;
        }
        System.out.println(result);
    }

    // 모든 파이어볼 이동
    static void move(){
        for(FireBall fireBall : fireBalls){
            int d = fireBall.d;
            int nx = (fireBall.x + vector[d][0] * fireBall.s) % N;
            int ny = (fireBall.y + vector[d][1] * fireBall.s) % N;
            if(nx <= 0) nx += N;
            if(ny <= 0) ny += N;
            fireBall.x = nx;
            fireBall.y = ny;
            fireBallGraph[nx][ny].add(fireBall);
        }
    }

    // 파이어볼 분열
    static void separate(){
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                // 분열 필요
                if(fireBallGraph[i][j].size() >= 2){
                    int fireBallNum = fireBallGraph[i][j].size();
                    int mSum = 0;
                    int sSum = 0;
                    int evenNum = 0;
                    int oddNum = 0;
                    for(FireBall fireBall : fireBallGraph[i][j]){
                        mSum += fireBall.m;
                        sSum += fireBall.s;
                        if(fireBall.d % 2 == 0) evenNum++;
                        else oddNum++;
                        // 분열했으니 원래 있는 녀석은 삭제
                        fireBalls.remove(fireBall);
                    }
                    fireBallGraph[i][j].clear();
                    // 질량 부족 => 분열 실패
                    if(mSum < 5) continue;
                    int mNew = mSum / 5;
                    int sNew = sSum / fireBallNum;
                    // 0 2 4 6
                    if(evenNum == fireBallNum || oddNum == fireBallNum){
                        for(int num = 0; num < 4; num++){
                            fireBalls.add(new FireBall(i, j, mNew, sNew, num*2));
                        }
                    }
                    // 1 3 5 7
                    else{
                        for(int num = 0; num < 4; num++){
                            fireBalls.add(new FireBall(i, j, mNew, sNew, num*2+1));
                        }
                    }
                }
                // 분열 필요 x
                else{
                    fireBallGraph[i][j].clear();
                }
            }
        }
    }

    static class FireBall{
        int x;
        int y;
        int m;
        int d;
        int s;
        FireBall(int x, int y, int m, int s, int d){
            this.x = x;
            this.y = y;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }
}
