import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem21921 {
    static int X, N;
    static int[] inputs;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        inputs = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
            inputs[i] = inputs[i] + inputs[i - 1];
        }
        int maxValue = 0;
        int num = 0;
        for(int i = X; i < N + 1; i++){
            int nowN = inputs[i] - inputs[i - X];
            if(maxValue < nowN){
                num = 1;
                maxValue = nowN;
            }
            else if(maxValue == nowN){
                num++;
            }
        }
        if(maxValue == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(maxValue);
        System.out.println(num);
    }
}
