import java.util.Scanner;

public class Problem2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sBuilder = new StringBuilder();
        int N = sc.nextInt();
        for(int i = 0; i < 2 * N - 1; i++){
            if(i < N){
                for(int j = 0; j < i + 1; j++){
                    sBuilder.append('*');
                }
                for(int j = 0; j < 2 * N - (i + 1) * 2; j++){
                    sBuilder.append(' ');
                }
                for(int j = 0; j < i + 1; j++){
                    sBuilder.append('*');
                }
                sBuilder.append('\n');
            }
            else{
                for(int j = 0; j < N - (i - N + 1); j++){
                    sBuilder.append('*');
                }
                for(int j = 0; j < (i - N + 1) * 2; j++){
                    sBuilder.append(' ');
                }
                for(int j = 0; j < N - (i - N + 1); j++){
                    sBuilder.append('*');
                }
                sBuilder.append('\n');
            }
        }
        System.out.print(sBuilder);
    }
}
