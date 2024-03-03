package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [G5] 백준 14891 톱니바퀴
 * 메모리 : 11616 KB
 * 시간 : 80 ms
 * 코드 길이 : 5008 B
 * 아이디어 : 톱니바퀴가 돌아야하는지 돌면 안되는지를 재귀를 통해서 판단해준 다음에,
 * 톱니바퀴를 돌려준다. 톱니바퀴를 실제로 돌릴필요는 없고 가리키는 인덱스의 위치만 옮겨주었다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/14891">
 *
 */
public class Problem14891 {
    static char[][] gear = new char[4][8];
    // 0 은 12시 1은 3시 2는 9시를 가리킴
    static int[][] gearPointer = new int[4][3];
    // 돌릴지 안돌릴지 결정한다 0 이면 안돌리고 1이면 시계방향 -1이면 반시계방향
    static int[] gearRotate = new int[4];
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        for(int i = 0; i < 4; i++){
            gear[i] = br.readLine().toCharArray();
        }
        // pointer setting
        for(int i = 0; i < 4; i++){
            // i 번째 기어의 12시를 가리킴
            gearPointer[i][0] = 0;
            // i 번째 기어의 3시를 가리킴
            gearPointer[i][1] = 2;
            // i 번째 기어의 9시를 가리킴
            gearPointer[i][2] = 6;
        }
        // Query Start
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            gearRotate[gearNum] = dir;
            leftGear(gearNum - 1, dir * -1);
            rightGear(gearNum + 1, dir * -1);
            for(int j = 0; j < 4; j++){
                // j 번째 기어를 설정된 방향으로 돌린다
                rotate(j, gearRotate[j]);
            }
            setGearRotate();
        }

        // 점수 계산
        int result = 0;
        for(int i = 0; i < 4; i++){
            if(gear[i][gearPointer[i][0]] == '1'){
                result += (int) Math.pow(2, i);
            }
        }
        System.out.println(result);
    }

    // 어느 기어를 어느 방향으로 돌릴지 결정한다
    static void leftGear(int idx, int dir){
        if(idx < 0){
            return;
        }
        // 기어가 다르면 고
        if(gear[idx][gearPointer[idx][1]] != gear[idx + 1][gearPointer[idx + 1][2]]){
            leftGear(idx - 1, dir * -1);
            gearRotate[idx] = dir;
        }
    }



    static void rightGear(int idx, int dir){
        if(idx > 3){
            return;
        }
        // 기어가 다르면 고
        if(gear[idx][gearPointer[idx][2]] != gear[idx - 1][gearPointer[idx - 1][1]]){
            rightGear(idx + 1, dir * -1);
            gearRotate[idx] = dir;
        }
    }


    // 해당 인덱스의 기어를 특정 방향으로 돌린다
    static void rotate(int idx, int dir){
        // 시계 방향
        if(dir == 1){
            // 12 시 가리키던 친구
            gearPointer[idx][0]--;
            if(gearPointer[idx][0] == -1) {
                gearPointer[idx][0] = 7;
            }
            // 3 시 가리키던 친구
            gearPointer[idx][1]--;
            if(gearPointer[idx][1] == -1) {
                gearPointer[idx][1] = 7;
            }
            // 9 시 가리키던 친구
            gearPointer[idx][2]--;
            if(gearPointer[idx][2] == -1) {
                gearPointer[idx][2] = 7;
            }
        }
        // 반시계 방향
        else if(dir == -1){
            // 12 시 가리키던 친구
            gearPointer[idx][0]++;
            if(gearPointer[idx][0] == 8) {
                gearPointer[idx][0] = 0;
            }
            // 3 시 가리키던 친구
            gearPointer[idx][1]++;
            if(gearPointer[idx][1] == 8) {
                gearPointer[idx][1] = 0;
            }
            // 9 시 가리키던 친구
            gearPointer[idx][2]++;
            if(gearPointer[idx][2] == 8) {
                gearPointer[idx][2] = 0;
            }
        }
    }
    static void setGearRotate(){
        for(int i = 0; i < 4; i++){
            gearRotate[i] = 0;
        }
    }

}
