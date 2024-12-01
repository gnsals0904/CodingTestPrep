import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2666 {
    static int N, Q;
    static int result = Integer.MAX_VALUE;
    static int[] useDoorIdx = new int[2];
    static int[] inputs;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        useDoorIdx[0] = Integer.parseInt(st.nextToken());
        useDoorIdx[1] = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(br.readLine());
        inputs = new int[Q];
        for(int i = 0; i < Q; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, 0, useDoorIdx[0], useDoorIdx[1]);
        System.out.println(result);
    }

    static void dfs(int k, int count, int aOpenDoorIdx, int bOpenDoorIdx){
        if(k == Q){
            result = Math.min(result, count);
            return;
        }
        int nowDoorIdx = inputs[k];
        if(aOpenDoorIdx == nowDoorIdx){
            dfs(k+1, count, aOpenDoorIdx, bOpenDoorIdx);
        }
        else if(bOpenDoorIdx == nowDoorIdx){
            dfs(k+1, count, aOpenDoorIdx, bOpenDoorIdx);
        }
        else{
            int a = Math.abs(nowDoorIdx - aOpenDoorIdx);
            int b = Math.abs(nowDoorIdx - bOpenDoorIdx);
            dfs(k+1, count + a, nowDoorIdx, bOpenDoorIdx);
            dfs(k+1, count + b, aOpenDoorIdx, nowDoorIdx);
        }
    }
}
