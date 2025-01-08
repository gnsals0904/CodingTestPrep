package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem1202 {
    static int N, K;
    static Thing[] things;
    static TreeMap<Integer, Integer> bags = new TreeMap<>();
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        things = new Thing[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            things[i] = new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(things);
        for(int i = 0; i < K; i++){
            int bag = Integer.parseInt(br.readLine());
            if(bags.containsKey(bag)) bags.put(bag, bags.get(bag) + 1);
            else bags.put(bag, 1);
        }
        for(Thing t : things){
            Integer ceilingKey = bags.ceilingKey(t.weight);
            if(ceilingKey != null){
                int bag = bags.get(ceilingKey);
                if(bag > 1){
                    result += t.value;
                    bags.put(ceilingKey, bags.get(ceilingKey) - 1);
                } else if(bag == 1){
                    result += t.value;
                    bags.remove(ceilingKey);
                }
            }
        }
        System.out.println(result);
    }

    static class Thing implements Comparable<Thing> {
        int weight;
        int value;

        public Thing(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Thing o) {
            return o.value - this.value;
        }

        @Override
        public String toString() {
            return "Thing{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }
}
