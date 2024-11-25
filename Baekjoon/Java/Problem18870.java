import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem18870 {
    static int N;
    static int[] arr;
    static int[] sortedArr;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sortedArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }
        int idx = -1;
        Arrays.sort(sortedArr);
        for(int i = 0; i < N; i++){
            if(map.containsKey(sortedArr[i])){
                map.put(sortedArr[i], idx);
            }
            else{
                idx++;
                map.put(sortedArr[i], idx);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
