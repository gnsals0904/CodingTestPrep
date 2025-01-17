import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16987 {
    static int N;
    static Egg[] eggs;
    static boolean[] isBroken;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        isBroken = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int brokenCount, int k){
        for(int i = 0; i < N; i++){
            if(isBroken[i]) continue;
            if(k == i) continue;
            int handEggHealth = eggs[k].health - eggs[i].dmg;
            int attackEggHealth = eggs[i].health - eggs[k].dmg;
            eggs[k].health = handEggHealth;
            eggs[i].health = attackEggHealth;
            if(handEggHealth <= 0) {
                isBroken[k] = true;
                brokenCount++;
            }
            if(attackEggHealth <= 0) {
                isBroken[i] = true;
                brokenCount++;
            }
            int cur = k+1;
            boolean flag = false;
            while(cur < N){
                if(!isBroken[cur]){
                    dfs(brokenCount, cur);
                    flag = true;
                }
                if(flag) break;
                cur++;
            }
            result = Math.max(result, brokenCount);
            if(handEggHealth <= 0) {
                isBroken[k] = false;
                brokenCount--;
            }
            if(attackEggHealth <= 0) {
                isBroken[i] = false;
                brokenCount--;
            }
            eggs[k].health = handEggHealth + eggs[i].dmg;
            eggs[i].health = attackEggHealth + eggs[k].dmg;
        }
    }

    static class Egg{
        int health;
        int dmg;

        Egg(int health, int dmg){
            this.health = health;
            this.dmg = dmg;
        }
    }
}
