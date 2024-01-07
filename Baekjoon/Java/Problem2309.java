import java.util.Arrays;
import java.util.Scanner;

public class Problem2309 {
    public static void main(String[] args) {
        int[] arr = new int[9];
        int[] result = new int[7];
        int arr_sum = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            arr[i] = sc.nextInt();
            arr_sum += arr[i];
        }
        for(int i = 0; i < 9; i++){
            for(int j = i + 1; j < 9; j++){
                int temp = arr_sum - arr[i] - arr[j];
                if(temp == 100){
                    for(int x = 0; x < 9; x++){
                        if(x == i || x == j){
                            continue;
                        }
                        else{
                            result[count] = arr[x];
                            count++;
                        }
                    }
                    Arrays.sort(result);
                    for(int x = 0; x < 7; x++){
                        System.out.println(result[x]);
                    }
                    return;
                }
            }
        }
    }
}
