package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Problem7662 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int T = Integer.parseInt(br.readLine());
        int test_case = 0;
        while(test_case < T){
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for(int i = 0; i < k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                char a = st.nextToken().charAt(0);
                int b = Integer.parseInt(st.nextToken());
                // 삽입
                if(a == 'I'){
                    treeMap.put(b, treeMap.getOrDefault(b, 0) + 1);
                }
                // 삭제
                else{
                    if(treeMap.isEmpty()){
                        continue;
                    }
                    // 최댓값 삭제
                    int n;
                    if(b == 1){
                        n = treeMap.lastKey();
                    }
                    // 최솟값 삭제
                    else{
                        n = treeMap.firstKey();
                    }
                    if(treeMap.put(n, treeMap.get(n) - 1) == 1){
                        treeMap.remove(n);
                    }
                }
            }
            if(treeMap.isEmpty()){
                System.out.println("EMPTY");
            }else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
            test_case++;
        }
    }
}
