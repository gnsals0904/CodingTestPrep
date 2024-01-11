import java.util.Scanner;

public class Problem10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[5];
        int max_len = 0;
        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextLine();
            if(arr[i].length() > max_len) {
                max_len = arr[i].length();
            }
        }
        for(int i = 0; i < 5; i++){
            int temp = arr[i].length();
            if(temp < max_len){
                for(int j = 0; j < max_len - temp; j++) {
                    arr[i] = arr[i] + " ";
                }
            }
        }


        for(int i = 0; i < max_len; i++){
            for(int j = 0; j < 5; j++){
                char r = arr[j].charAt(i);
                if(r == ' '){
                    continue;
                }
                System.out.print(r);
            }
        }
    }
}
