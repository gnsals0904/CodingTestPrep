import java.util.Scanner;

public class Problem4562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i = 0; i < test_case; i++){
            int num_brain = sc.nextInt();
            int num_zombie = sc.nextInt();
            if(num_brain >= num_zombie){
                System.out.println("MMM BRAINS");
            }
            else{
                System.out.println("NO BRAINS");
            }
        }
    }
}
