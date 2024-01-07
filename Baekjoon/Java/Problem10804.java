import java.util.Scanner;

public class Problem10804 {
    public static void main(String[] args) {
        int[] card = new int[20];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < 20; i++){
            card[i] = i + 1;
        }
        for(int i = 0;i < 10; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int num = b - a + 1;
            for(int j = 0; j < num / 2 ; j++){
                int temp = card[a + j - 1];
                card[a + j - 1] = card[b - j - 1];
                card[b - j - 1] = temp;
            }
        }
        for(int i = 0;i < 20; i++){
            if(i != 19){
                System.out.print(card[i] +" ");
            }
            else{
                System.out.print(card[i]);
            }
        }
    }
}
