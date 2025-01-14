package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem19700 {
    static int N;
    static Person[] people;
    static TreeMap<Integer, Queue<Integer>> groupMap = new TreeMap<>();
    static ArrayList<ArrayList<Person>> group = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new Person[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(people);
        for (Person p : people) {
            Integer key = groupMap.lowerKey(p.max);
            if(key == null) {
                makeNewGroup(p);
                continue;
            }
            Queue<Integer> groupList = groupMap.get(key);
            if(groupList.isEmpty()) continue;
            int groupIdx = groupList.poll();
            if(groupList.isEmpty()){
                groupMap.remove(key);
            }
            Queue<Integer> temp = groupMap.get(key + 1);
            if(temp == null) {
                temp = new LinkedList<>();
                temp.add(groupIdx);
                groupMap.put(key + 1, temp);
                continue;
            }
            temp.add(groupIdx);
        }
        System.out.println(group.size());
    }

    static void makeNewGroup(Person p){
        Queue<Integer> groupList = groupMap.get(1);
        group.add(new ArrayList<>());
        group.get(group.size() - 1).add(p);
        if(groupList == null){
            groupMap.put(1, new LinkedList<>());
            groupMap.get(1).add(group.size() - 1);
            return;
        }
        groupList.add(group.size() - 1);
    }

    static class Person implements Comparable<Person> {
        int length;
        int max;

        public Person(int length, int max){
            this.length = length;
            this.max = max;
        }

        @Override
        public int compareTo(Person o) {
            return o.length - this.length;
        }
    }
}
