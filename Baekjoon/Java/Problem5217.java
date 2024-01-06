import java.util.Scanner;

public class Problem5217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < test_case; i++){
            int n = sc.nextInt();
            int a = 1;
            int b = n - a;
            while (a < b){
                sBuilder.append(" " + a + " " + b);
                a++;
                b--;
                if (a < b){
                    sBuilder.append(",");
                }
            }
            System.out.println("Pairs for " + n + ":" + sBuilder);
            sBuilder.setLength(0);
        }

    }
}
