import java.util.Scanner;

public class Problem6810 {
    public static void main(String[] args) {
        int result = 9 * 1 + 7 * 3 + 8 * 1 + 0 * 3 + 9 * 1 + 2 * 3 + 1 * 1 + 4 * 3 + 1 * 1 + 8 * 3;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            if(i == 1){
                result += sc.nextInt() * 3;
            }
            else{
                result += sc.nextInt();
            }

        }
        System.out.println("The 1-3-sum is " + result);
    }

}
