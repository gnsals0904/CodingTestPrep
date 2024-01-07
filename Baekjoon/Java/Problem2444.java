import java.util.Scanner;

public class Problem2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sBuilder = new StringBuilder();
        int N = sc.nextInt();
        for(int i = 0; i < 2 * N - 1; i++){
            if(i < N){
                for(int j = i; j < N - 1; j++){
                    sBuilder.append(' ');
                }
                for(int j = 0; j < (i + 1) * 2 - 1; j++){
                    sBuilder.append('*');
                }
                sBuilder.append('\n');
            }
            else{
                for(int j = 0; j < (i + 1) - N; j++){
                    sBuilder.append(' ');
                }
                for(int j = 0; j < (2 * N - 1) - ((i - N + 1) * 2); j++){
                    sBuilder.append('*');
                }
                sBuilder.append('\n');
            }
        }
        System.out.print(sBuilder);
    }
}
