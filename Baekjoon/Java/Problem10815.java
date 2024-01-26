package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem10815 {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            if(i == M - 1){
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append(1);
                }
                else{
                    sb.append(0);
                }
            }else{
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append(1).append(" ");
                }
                else{
                    sb.append(0).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}
