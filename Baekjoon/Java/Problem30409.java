package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem30409 {
    // 전봇대의 개수
    static int N;
    // dp : memo
    // 왼쪽으로 연결되는 전선 dp
    static long[] left_dp;
    // 오른쪽으로 연결되는 전선 dp
    static long[] right_dp;
    // 가로등 정보
    static top[] build;
    // 계산할때 사용할 stack
    static Stack<top> stack;
    // 쿼리 수
    static int Q;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        // 전봇대의 개수 받기
        N = Integer.parseInt(br.readLine());
        // 초기 생성 및 세팅
        build = new top[N + 1];
        left_dp = new long[N + 1];
        right_dp = new long[N + 1];
        left_dp[0] = 0;
        right_dp[0] = 0;
        build[0] = new top(0, 0);
        stack = new Stack<>();
        // 가로등 높이 넣기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            build[i] = new top (i, Integer.parseInt(st.nextToken()));
        }
        // left dp 넣기
        for(int i = 1; i < N + 1; i++){
            // stack 이 비어있으면
            if(stack.isEmpty()){
                // 가로등의 높이를 넣고
                stack.add(build[i]);
                left_dp[i] = 0;
            }
            // stack 이 비어있지않으면
            else {
                // stack 이 비어있지 않고 stack 의 top 보다 지금 가로등보다 크면 아닐때까지 pop 한다
                while (!stack.isEmpty() && stack.peek().height < build[i].height){
                    stack.pop();
                }
                // 여기에 오면 스택이 비거나, stack 의 top 이 지금 가로등보다 큰 것이다.
                // 스택이 비어있다면
                if(stack.isEmpty()){
                    // 지금 들어온 가로등과 연결할 가로등은 없다
                    left_dp[i] = 0;
                    stack.add(build[i]);
                    // 다음으로 넘어간다
                    continue;
                }
                // 거리를 계산하고
                long dist = 0;
                dist = (long) (Math.pow(stack.peek().idx - build[i].idx, 2) + Math.pow(stack.peek().height - build[i].height, 2));
                // dp 결과 저장
                left_dp[i] = dist + left_dp[stack.peek().idx];
                // stack 의 top 보다 지금것이 크거나 같은 경우
                stack.add(build[i]);
            }
        }
        // stack 초기화 하고
        stack.clear();
        // right dp 넣기
        for(int i = N; i > 0; i--){
            // stack 이 비어있으면
            if(stack.isEmpty()){
                // 가로등의 높이를 넣고
                stack.add(build[i]);
                right_dp[i] = 0;
            }
            // stack 이 비어있지않으면
            else {
                // stack 이 비어있지 않고 stack 의 top 보다 지금 가로등보다 크면 아닐때까지 pop 한다
                while (!stack.isEmpty() && stack.peek().height < build[i].height){
                    stack.pop();
                }
                // 여기에 오면 스택이 비거나, stack 의 top 이 지금 가로등보다 큰 것이다.
                // 스택이 비어있다면
                if(stack.isEmpty()){
                    // 지금 들어온 가로등과 연결할 가로등은 없다
                    right_dp[i] = 0;
                    stack.add(build[i]);
                    // 다음으로 넘어간다
                    continue;
                }
                // 거리를 계산하고
                long dist = 0;
                dist = (long) (Math.pow(stack.peek().idx - build[i].idx, 2) + Math.pow(stack.peek().height - build[i].height, 2));
                // dp 결과 저장
                right_dp[i] = dist + right_dp[stack.peek().idx];
                // stack 의 top 보다 지금것이 크거나 같은 경우
                stack.add(build[i]);
            }
        }
        // 쿼리 개수 받기
        Q = Integer.parseInt(br.readLine());
        // start
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++){
            int q = Integer.parseInt(br.readLine());
            sb.append(left_dp[q] + right_dp[q]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    // 가로등 정보 저장 객체
    static class top{
        int idx;
        int height;
        top(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }

}