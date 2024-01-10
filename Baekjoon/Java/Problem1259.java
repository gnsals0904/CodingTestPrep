import java.util.Scanner;

public class Problem1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            boolean flag = true;
            int input = sc.nextInt();
            if (input == 0) {
                break;
            }
            String temp = input + "";
            int len_input = temp.length();
            for (int i = 0; i < len_input / 2; i++) {
                if (temp.charAt(i) != temp.charAt(len_input - i - 1)) {
                    System.out.println("no");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            }
        }
    }
}
