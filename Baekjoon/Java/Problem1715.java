package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * [G4] 백준 1715 카드 정렬하기
 * 메모리 : 25452 KB
 * 시간 : 340 ms
 * 코드 길이 : 892 B
 * 아이디어 : 카드를 정렬하기 위해서 최솟값은 가장 작은 카드 묶음 두개를 먼저 섞는 것이다.
 * 카드를 섞으면 새로운 카드 묶음이 탄생하는데, 해당 카드 묶음보다 작은 카드 묶음이 기존에 존재할 수 있기때문에
 * 우선순위 큐를 사용하는 것이 편리하다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/1715">
 *
 */
public class Problem1715 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pqueue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pqueue.add(Long.parseLong(br.readLine()));
        }
        // 비교 시작
        long result = 0;
        // 카드 묶음은 2개보다 많이 있어야 더하며 계산할 수 있다
        while(pqueue.size() >= 2){
            long num1 = pqueue.poll();
            long num2 = pqueue.poll();
            result += (num1 + num2);
            pqueue.add(num1 + num2);
        }
        // 여기오면 1개 남은것
        System.out.println(result);
    }
}
