package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1439 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String s = br.readLine();
        int[] count = new int[2];
        Arrays.fill(count, 0);
        char temp = s.charAt(0);
        int chg = 0;
        if(s.charAt(0) != s.charAt(s.length() - 1)) Arrays.fill(count, 1);
        for(int i = 1; i < s.length(); i++){
            if(temp != s.charAt(i)){
                count[chg]++;
                chg = change(chg);
                temp = s.charAt(i);
            }
        }
        System.out.println(Math.min(count[0], count[1]));
    }

    static int change(int n){
        if(n == 1) return 0;
        else return 1;
    }

}
