package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S4] 백준 1244 스위치 켜고 끄기
 * 메모리 : 14248 KB
 * 시간 : 124 ms
 * 코드 길이 : 4575 B
 * 아이디어 : 스위치의 개수 최대 100 학생수도 최대 100이므로 100 * 100 으로 완전탐색 구현해도 시간복잡도에 문제가 없다고 생각하여
 * 그대로 구현하였다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/1244">
 */
public class Problem1244 {
    public static void main(String[] args) throws IOException {
        // 입력받기 위해 필요한 InputStreamReader, BufferedReader 선언
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        // 스위치의 개수 입력 받기
        int switch_num = Integer.parseInt(br.readLine());
        // 스위치의 개수 만큼의 배열 생성
        int[] switch_state = new int[switch_num];
        // 스위치의 상태 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < switch_num; i++){
            switch_state[i] = Integer.parseInt(st.nextToken());
        }
        // 학생 수 입력 받기
        int student_num = Integer.parseInt(br.readLine());
        // 학생의 성별과 스위치 타겟을 저장할 변수
        int gender;
        int target;
        // 학생 수 만큼 스위치의 상태를 변경
        for(int i = 0; i < student_num; i++){
            // 입력 받기
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            // 배열은 0부터 시작이므로 1을 빼준다.
            target--;
            // 성별이 남자라면
            if(gender == 1){
                // target 의 배수 스위치들의 상태를 전부 변경한다
                for(int j = target; j < switch_num; j += target + 1){
                    // switch 상태가 0이었다면 1로 변경
                    if(switch_state[j] == 0){
                        switch_state[j] = 1;
                    }
                    // switch 상태가 1이었다면 0로 변경
                    else{
                        switch_state[j] = 0;
                    }
                }
            }
            // 성별이 여자라면
            else{

                // 가운데 있는 target 값을 반대로 바꾸어 준다.
                if(switch_state[target] == 0){
                    switch_state[target] = 1;
                }
                // switch 상태가 1이었다면 0로 변경
                else{
                    switch_state[target] = 0;
                }

                // 좌우가 대칭인 지점을 찾을때까지 그 구간의 스위치의 상태를 바꾼다.
                int count = 1;
                // 1. target 으로부터 count 만큼 왼쪽으로 가는 포인터가 0보다 작으면 안된다.
                // 2. target 으로부터 count 만큼 오른쪽으로 가는 포인터가 switch 의 개수보다 크면 안된다.
                // 3. 왼쪽 포인터와 오른쪽 포인터가 가리키는 값이 대칭이 아니면 안된다.
                while(target - count >= 0 && target + count < switch_num && switch_state[target - count] == switch_state[target + count]){
                    // 스위치 상태 변경
                    // 왼쪽 포인터가 가리키는 값이 1이라면 오른쪽 포인터가 가리키는 값도 1이므로 반대로 바꾸어 준다.
                    if(switch_state[target - count] == 1){
                        switch_state[target - count] = 0;
                        switch_state[target + count] = 0;
                    }
                    // 0이라면 1로 바꾸어 준다.
                    else{
                        switch_state[target - count] = 1;
                        switch_state[target + count] = 1;
                    }
                    // count 를 증가한다
                    count++;
                }
            }
        }
        // 결과를 출력하기 위해 스트링 빌더에 담아준다
        // 한줄에 20개만 출력해야하므로 20개마다 \n 를 넣어준다
        int i_count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < switch_num; i++){
            if(i == switch_num - 1){
                // 마지막은 공백을 출력하지 않는다.
                sb.append(switch_state[i]);
            }else {
                if(i_count == 20){
                    sb.append(switch_state[i]).append("\n");
                    i_count = 1;
                }else{
                    sb.append(switch_state[i]).append(" ");
                    i_count++;
                }

            }
        }
        System.out.print(sb);
    }
}
