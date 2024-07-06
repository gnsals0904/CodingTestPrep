package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1105 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();
        if(L.length() == R.length()){
            int count = 0;
            int idx = 0;
            char l = L.charAt(idx);
            char r = R.charAt(idx);
            while(l == r){
                if(l == '8' && r == '8'){
                    count++;
                }
                idx++;
                if(idx == L.length()) break;
                l = L.charAt(idx);
                r = R.charAt(idx);
            }
            System.out.println(count);
        }
        else{
            System.out.println(0);
        }
    }
}
