import java.util.Scanner;

public class Problem1568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int result = 0;
        while(N != 0){
            if(N >= count){
                N -= count;
                result++;
                count++;
            }
            else{
                count = 1;
            }
        }
        System.out.println(result);
    }
}
