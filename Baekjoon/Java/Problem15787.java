package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem15787 {
    static int trainNumber;
    static int[] train;
    static Set<Integer> result = new HashSet<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        trainNumber = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        train = new int[trainNumber];
        for(int i = 0; i < order; i++){
            st = new StringTokenizer(br.readLine());
            int action = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken()) - 1;
            if(action == 1){
                int seat = Integer.parseInt(st.nextToken()) - 1;
                ride(target, seat);
            }
            else if (action == 2){
                int seat = Integer.parseInt(st.nextToken()) - 1;
                getOff(target, seat);
            }
            else if (action == 3){
                goDown(target);
            }
            else {
                goUp(target);
            }
        }
        for(int i = 0; i < trainNumber; i++){
            result.add(train[i]);
        }
        System.out.println(result.size());
    }

    static void ride(int target, int seatNumber){
        train[target] = train[target] | (1 << seatNumber);
    }

    static void getOff(int target, int seatNumber){
        train[target] = train[target] & ~(1 << seatNumber);
    }

    static void goDown(int target){
        train[target] = (train[target] << 1) & 0xFFFFF;
    }

    static void goUp(int target){
        train[target] = train[target] >> 1;
    }
}
