package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem23326 {
    static int N, Q;
    static boolean[] goodPlaces;
    static TreeSet<Integer> places = new TreeSet<>();
    static int loc = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        goodPlaces = new boolean[N];
        Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(now == 1){
                places.add(i);
                goodPlaces[i] = true;
            }
            else
                goodPlaces[i] = false;
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            if(now == 1){
                int idx = Integer.parseInt(st.nextToken()) - 1;
                toggleGoodPlace(idx);
            } else if(now == 2){
                move(Integer.parseInt(st.nextToken()));
            } else {
                sb.append(findGoodPlace()).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void toggleGoodPlace(int i){
        if(goodPlaces[i]){
            goodPlaces[i] = false;
            places.remove(i);
        } else {
            goodPlaces[i] = true;
            places.add(i);
        }
    }

    static void move(int i){
        loc = (loc + i) % N;
    }

    static int findGoodPlace(){
        if(!places.isEmpty()){
            Integer temp = places.ceiling(loc);
            if(temp == null){
                return N - loc + places.first();
            }
            return temp - loc;
        }
        return -1;
    }
}
