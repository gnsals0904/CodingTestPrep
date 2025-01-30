import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1043 {
    static int N, M;
    static boolean[] cantLiePerson;
    static boolean[] cantLieGroup;
    static Queue<Integer> queue = new LinkedList<>();
    static HashMap<Integer, ArrayList<Integer>> peopleMap = new HashMap<>();
    static ArrayList<Integer>[] groupInfo;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = M;
        groupInfo = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            groupInfo[i] = new ArrayList<>();
        }
        cantLiePerson = new boolean[N + 1];
        cantLieGroup = new boolean[M + 1];
        st = new StringTokenizer(br.readLine());
        int init = Integer.parseInt(st.nextToken());
        for(int i = 0; i < init; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++){
                int temp = Integer.parseInt(st.nextToken());
                addGroup(i, temp);
                groupInfo[i].add(temp);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            ArrayList<Integer> group = peopleMap.get(now);
            if(group == null) continue;
            for(int groupNum : group){
                if(cantLieGroup[groupNum]) continue;
                cantLieGroup[groupNum] = true;
                result--;
                for(int personNum : groupInfo[groupNum]){
                    if(cantLiePerson[personNum]) continue;
                    cantLiePerson[personNum] = true;
                    queue.add(personNum);
                }
            }
        }
        System.out.println(result);
    }

    static void addGroup(int groupIdx, int personIdx){
        if(!peopleMap.containsKey(personIdx)){
            peopleMap.put(personIdx, new ArrayList<>());
        }
        peopleMap.get(personIdx).add(groupIdx);
    }
}
