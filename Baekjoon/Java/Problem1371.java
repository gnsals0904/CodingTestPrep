import java.util.Scanner;

public class Problem1371 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        char[] char_arr;
        while(sc.hasNext()){
            String one_line = sc.nextLine();
            char_arr = one_line.toCharArray();
            for(char temp : char_arr){
                if(temp == ' '){
                    continue;
                }
                int num = temp;
                arr[num - 97]++;
            }
        }
        int max_count = 0;
        for(int temp : arr){
            if(temp > max_count){
                max_count = temp;
            }
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] == max_count) {
                System.out.print((char) (i + 97));
            }
        }
    }
}
