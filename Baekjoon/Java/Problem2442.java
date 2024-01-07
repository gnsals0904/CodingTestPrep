import java.util.Scanner;

public class Problem2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sBuilder = new StringBuilder();
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            for(int j = i; j < N - 1; j++){
                sBuilder.append(' ');
            }
            for(int j = 0; j < (i + 1) * 2 - 1; j++){
                sBuilder.append('*');
            }
            sBuilder.append('\n');
        }
        System.out.print(sBuilder);
    }

}
