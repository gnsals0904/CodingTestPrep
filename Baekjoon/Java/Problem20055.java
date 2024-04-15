package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem20055 {
    // 길이
    static int N;
    // 내구도 깍인 칸 개수
    static int K;
    static belt[] belts;
    static int result;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        belts = new belt[2*N];
        for(int i = 0; i < 2*N; i++) {
            belts[i] = new belt(false, Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        while(result < K) {
            rotate();
            moveRobot();
            addRobot();
            count++;
        }
        System.out.println(count);
    }
    


    // Robot 올리기
    static void addRobot() {
        if(belts[0].durability > 0) {
            // 내구도를 줄이고 로봇을 이동시킨다
            belts[0].durability--;
            if(belts[0].durability == 0) result++;
            belts[0].haveRobot = true;
        }
    }

    // Robot 이 이동한다
    static void moveRobot() {
        for(int i = N - 2; i >= 0; i--) {
            if(belts[i].haveRobot) {
                // belts 의 내구도가 남아있고, 앞에 로봇이 없으면
                if(belts[i+1].durability > 0 && !belts[i+1].haveRobot) {
                    // 내구도를 줄이고 로봇을 이동시킨다
                    belts[i+1].durability--;
                    if(belts[i+1].durability == 0) result++;
                    belts[i+1].haveRobot = true;
                    belts[i].haveRobot = false;
                }
            }
        }
        // 로봇 내리기
        if(belts[N - 1].haveRobot) {
            belts[N - 1].haveRobot = false;
        }
    }

    // belt가 회전한다
    static void rotate() {
        belt temp = belts[2*N-1];
        for(int i = 2*N-1; i > 0; i--) {
            belts[i] = belts[i - 1];
        }
        // 로봇 내리기
        if(belts[N - 1].haveRobot) {
            belts[N - 1].haveRobot = false;
        }
        belts[0] = temp;
    }


    // belt 한 칸
    static class belt{
        boolean haveRobot;
        int durability;
        belt(boolean haveRobot, int durability){
            this.haveRobot = haveRobot;
            this.durability = durability;
        }

        @Override
        public String toString() {
            return "belt [haveRobot=" + haveRobot + ", durability=" + durability + "]";
        }
    }

}
