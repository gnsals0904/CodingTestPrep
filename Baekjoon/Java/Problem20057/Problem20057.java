package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem20057 {
    static boolean[][] visited;
    static int[][] graph;
    static int N;
    // 좌 하 우 상
    static int[][] vector = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    static int windX, windY, windDir = 0, maxL = 1;
    static int goCount = 0;
    static int preWindDir = 0;
    static int result = 0;
    static int[][][] sepVectors = {
            {{-2 , 0 , 2}, {-1, -1, 10}, {-1, 0, 7}, {-1, 1, 1}, {0, -2, 5}, {1, -1, 10}, {1, 0, 7}, {1, 1, 1}, {2, 0, 2}},
            {{0 , -2 , 2}, {1, -1, 10}, {0, -1, 7}, {-1, -1, 1}, {2, 0, 5}, {1, 1, 10}, {0, 1, 7}, {-1, 1, 1}, {0, 2, 2}},
            {{-2 , 0 , 2}, {-1, -1, 1}, {-1, 0, 7}, {-1, 1, 10}, {0, 2, 5}, {1, -1, 1}, {1, 0, 7}, {1, 1, 10}, {2, 0, 2}},
            {{0 , -2 , 2}, {1, -1, 1}, {0, -1, 7}, {-1, -1, 10}, {-2, 0, 5}, {1, 1, 1}, {0, 1, 7}, {-1, 1, 10}, {0, 2, 2}},
    };
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        graph = new int[N][N];
        windX = N/2;
        windY = N/2;
        visited[windX][windY] = true;
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(moveWind()){
            separate();
            preWindDir = windDir;
        }
        // 답출력
        System.out.println(result);

    }

    // 모래 흩날리기
    static void separate() {
        int totalSand = graph[windX][windY];
        int totalSent = 0;
        for (int[] sepVector : sepVectors[preWindDir]) {
            int nx = windX + sepVector[0];
            int ny = windY + sepVector[1];
            int tempSand = totalSand * sepVector[2] / 100;
            totalSent += tempSand;
            if (isIn(nx, ny)) {
                graph[nx][ny] += tempSand;
            } else {
                result += tempSand;
            }
        }
        int nx = windX + vector[preWindDir][0];
        int ny = windY + vector[preWindDir][1];
        int alphaSand = totalSand - totalSent;
        if (isIn(nx, ny)) {
            graph[nx][ny] += alphaSand;
        } else {
            result += alphaSand;
        }
        graph[windX][windY] = 0;
    }

    // 좌표가 유효한지
    static boolean isIn(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }

    // 토네이도 이동
    static boolean moveWind(){
        if(windX == 0 && windY == 0) return false;
        int nx = windX + vector[windDir][0];
        int ny = windY + vector[windDir][1];
        if(visited[nx][ny]){
            windDir = windDir - 1;
            if(windDir < 0) windDir += 4;
            nx = windX + vector[windDir][0];
            ny = windY + vector[windDir][1];
            windDir = (windDir + 1) % 4;
            maxL++;
            windX = nx;
            windY = ny;
            visited[windX][windY] = true;
            return true;
        }
        goCount++;
        if(goCount == maxL){
            windDir = (windDir + 1) % 4;
            goCount = 0;
            if (windDir == 0 || windDir == 2) {
                maxL++;
            }
        }
        windX = nx;
        windY = ny;
        visited[windX][windY] = true;
        return true;
    }
}
