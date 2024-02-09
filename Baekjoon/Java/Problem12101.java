package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem12101 {
    static ArrayList<String> result = new ArrayList<String>();
    static int n;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = "";
        dfs(n, str);
        if(result.size() < k){
            System.out.println(-1);
        }
        else {
            System.out.println(result.get(k - 1));
        }
    }

    static void dfs(int now_n, String temp_result) {
        if (now_n == 0) {
            result.add(temp_result);
            return;
        }
        if (now_n - 1 >= 0) {
            if (n == now_n) {
                temp_result = temp_result + "1";
                dfs(now_n - 1, temp_result);
                temp_result = temp_result.substring(0, temp_result.length() - 1);
            } else {
                temp_result = temp_result + "+1";
                dfs(now_n - 1, temp_result);
                temp_result = temp_result.substring(0, temp_result.length() - 2);
            }
            if (now_n - 2 >= 0) {
                if (n == now_n) {
                    temp_result = temp_result + "2";
                    dfs(now_n - 2, temp_result);
                    temp_result = temp_result.substring(0, temp_result.length() - 1);
                } else {
                    temp_result = temp_result + "+2";
                    dfs(now_n - 2, temp_result);
                    temp_result = temp_result.substring(0, temp_result.length() - 2);
                }

            }
            if (now_n - 3 >= 0) {
                if (n == now_n) {
                    temp_result = temp_result + "3";
                    dfs(now_n - 3, temp_result);
                    temp_result = temp_result.substring(0, temp_result.length() - 1);
                } else {
                    temp_result = temp_result + "+3";
                    dfs(now_n - 3, temp_result);
                    temp_result = temp_result.substring(0, temp_result.length() - 2);
                }

            }
        }
    }
}
