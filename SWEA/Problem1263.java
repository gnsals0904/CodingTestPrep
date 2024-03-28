package swea;

import java.util.*;
import java.io.*;

/**
 * [D6] SWEA 1263 [S/W 문제해결 응용] 8일차 - 사람 네트워크2
 * 메모리 : 105,620 KB
 * 시간 : 1,258 ms
 * 코드 길이 : 3,691 B
 * 아이디어 : 한 정점에서 다른 모든 정점으로의 최단거리의 합을 더해야한다 => 플로이드 워셜을 사용한다
 *
 * @author 김훈민
 * @see <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN">
 *
 */
class Problem1263
{
	// 정점의 개수는 최대 1000개이므로 1000 * 1000 + 1 을 max 값으로 지정해준다.
    static final int max_v = 1000001;
	public static void main(String args[]) throws Exception
	{
		// 입력을 받는다
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        int[][] graph;
        // 테스트 케이스를 진행한다
        for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            graph = new int[N][N];
            // graph 를 초기값(최댓값)으로 갱신한다.
            for(int i = 0; i < N; i++){
            	Arrays.fill(graph[i], max_v);
            }
            // graph 입력을 받는다.
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp != 0){
                        graph[i][j] = 1;
                    }
                }
            }
            // 플로이드 워셜 진행
            for(int k = 0; k < N; k++){
            	for(int i = 0; i < N; i++){
                	for(int j = 0; j < N; j++){
                    	graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
            // 최소값 찾기
            int min_p = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
            	int tmp = 0;
               	for(int j = 0; j < N; j++){
               		// 자기 자신으로 가는 경우는 더하지 않는다.
                    if(i == j) continue;
                	tmp += graph[i][j];
                }
                if(min_p > tmp){
                    min_p = tmp;
                }
            }
            // 조건에 맞게 출력한다.
            sb.append("#").append(test_case).append(" ").append(min_p).append("\n");
        }
        System.out.print(sb);
	}

}
