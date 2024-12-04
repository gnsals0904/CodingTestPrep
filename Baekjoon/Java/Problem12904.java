import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem12904 {
    static String target;
    static String init;
    static char[] t;
    static boolean isReverse;
    static int frontPoint, backPoint;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        init = br.readLine();
        target = br.readLine();
        t = new char[target.length()];
        t = target.toCharArray();
        backPoint = target.length() - 1;
        int tLen = backPoint - frontPoint + 1;
        while(tLen != init.length()) {
            if(isReverse){
                if(t[frontPoint] == 'B'){
                    isReverse = false;
                    frontPoint++;
                } else{
                    frontPoint++;
                }
            }else{
                if(t[backPoint] == 'B'){
                    isReverse = true;
                    backPoint--;
                }
                else{
                    backPoint--;
                }
            }
            tLen = backPoint - frontPoint + 1;
        }
        StringBuilder sb = new StringBuilder();
        if(isReverse){
            for(int i = backPoint; i >= frontPoint; i--){
                sb.append(t[i]);
            }
        }
        else{
            for(int i = frontPoint; i < backPoint + 1; i++){
                sb.append(t[i]);
            }
        }
        if(init.equals(sb.toString())){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
