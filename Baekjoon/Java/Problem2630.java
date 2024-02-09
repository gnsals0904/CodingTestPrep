package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S2] 백준 2630 색종이 만들기
 * 메모리 : 15652KB
 * 시간 : 164ms
 * 코드 길이 : 2917B
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2630">
 */
public class Problem2630 {
    // 흰색 종이의 수 와 파랑색 종이의 수 종이의 모양을 저장할 변수들 선언
    static int blue_num = 0;
    static int white_num = 0;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        // 입력 받을 InputStreamReader 와 BufferedReader 선언
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        // 한 줄 입력받고 int 로 형변환을 해준다
        int N = Integer.parseInt(br.readLine());
        // N * N 의 2차원 배열 생성
        graph = new int[N][N];
        // 2차원 배열에 값 넣기
        for(int i = 0; i < N; i++){
            // StringTokenizer 생성해서 한 줄 입력받고
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                // 공백기준 하나씩 int 로 변환하여 graph 에 넣기
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 재귀 함수 호출
        func(0, 0, N);
        // 답 출력
        System.out.println(white_num);
        System.out.println(blue_num);

    }
    // 색종이를 자르는 함수 (재귀 함수) x와 y는 색종이의 왼쪽위 좌표, n은 현재 보고있는 색종이의 길이
    public static void func(int x, int y, int n){
        // n이 1이면 색종이는 이미 한칸이므로 더 자를 수 없으니 색을 보고 개수를 올려준다
        if(n == 1){
            if(graph[x][y] == 1){
                blue_num++;
            }
            else{
                white_num++;
            }
            return;
        }
        // 색종이를 왼쪽위부터 탐색하다가 다른 색이 나오면 재귀함수를 호출하여 색종이를 자른다
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                // 다른 색이 있으면 더 탐색할 필요 없이 바로 색종이 자르기
                if(graph[x][y] != graph[i][j]){
                    // 색종이를 자르면 4등분이 되므로 4등분 된 색종이의 각 왼쪽 위 모서리 기준 재귀 호출 당연히 길이는 절반이 된다
                    func(x, y, n / 2);
                    func(x + n / 2, y, n / 2);
                    func(x, y + n / 2, n / 2);
                    func(x + n / 2, y + n / 2, n / 2);
                    return;
                }
            }
        }
        // 여기까지 왔다면, 색종이의 색이 모두 같았던 것이므로 해당 색의 개수를 올려준다
        if(graph[x][y] == 1){
            blue_num++;
        }
        else{
            white_num++;
        }
    }
}
