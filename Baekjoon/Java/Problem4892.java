import java.util.Scanner;

public class Problem4892 {
    public static void main(String[] args) {
        int count = 1;
        Scanner sc = new Scanner(System.in);
        while (true){
            int input = sc.nextInt();
            if(input == 0){
                break;
            }
            System.out.print(count + ". ");
            int n1 = input * 3;
            // even
            if(n1 % 2 == 0){
                System.out.print("even ");
                n1 = n1 / 2;
            }
            else{
                System.out.print("odd ");
                n1 = (n1 + 1) / 2;
            }
            int n4 = (n1 * 3) / 9;
            System.out.println(n4);
            count++;
        }
    }
}
