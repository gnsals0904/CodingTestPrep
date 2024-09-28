package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem19941 {
    static int len;
    static int range;
    static String inputs;
    static Queue<Integer> hamburger = new LinkedList<>();
    static Queue<Integer> people = new LinkedList<>();
    static int result;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        inputs = br.readLine();
        for(int i = 0 ; i < len; i++){
            if(isH(inputs.charAt(i))){
                boolean canEat = false;
                while(!people.isEmpty()){
                    int nowPeople = people.poll();
                    if(i - nowPeople <= range){
                        result++;
                        canEat = true;
                        break;
                    }
                }
                if(!canEat)
                    hamburger.add(i);
            }
            else{
                boolean canEat = false;
                while(!hamburger.isEmpty()){
                    int nowHamburger = hamburger.poll();
                    if(i - nowHamburger <= range){
                        result++;
                        canEat = true;
                        break;
                    }
                }
                if(!canEat)
                    people.add(i);
            }
        }
        System.out.println(result);
    }

    static boolean isH(char c){
        return c == 'H';
    }
}
