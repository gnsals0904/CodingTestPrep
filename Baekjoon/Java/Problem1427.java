package com.ssafy.algo03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        Integer[] arr = new Integer[N.length()];
        for(int i = 0; i < N.length(); i++){
            arr[i] = N.charAt(i) - '0';
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(Integer i : arr){
            System.out.print(i);
        }
    }
}
