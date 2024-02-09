import java.util.Scanner;

public class Problem6778 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int antenna = sc.nextInt();
        int eye = sc.nextInt();
        if (antenna >= 3 && eye <= 4){
            System.out.println("TroyMartian");
        }
        if (antenna <= 6 && eye >= 2){
            System.out.println("VladSaturnian");
        }
        if (antenna <= 2 && eye <= 3){
            System.out.println("GraemeMercurian");
        }
    }
}
