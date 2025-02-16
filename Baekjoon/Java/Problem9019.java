import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem9019 {
    static int T;
    static int start, target;
    static boolean[] used = new boolean[10000];
    static Queue<Node> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            sb.append(bfs(start)).append("\n");
            setUsed();
            queue.clear();
        }
        System.out.print(sb);
    }

    static String bfs(int n){
        queue.add(new Node(n, ""));
        used[n] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.number == target) return cur.orders;

            int d = orderD(cur.number);
            if (!used[d]) {
                queue.add(new Node(d, cur.orders +"D"));
                used[d] = true;
            }

            int s = orderS(cur.number);
            if (!used[s]) {
                queue.add(new Node(s, cur.orders +"S"));
                used[s] = true;
            }

            int l = orderL(cur.number);
            if (!used[l]) {
                queue.add(new Node(l, cur.orders +"L"));
                used[l] = true;
            }

            int r = orderR(cur.number);
            if (!used[r]) {
                queue.add(new Node(r, cur.orders +"R"));
                used[r] = true;
            }
        }
        return "error";
    }

    static class Node {
        int number;
        String orders;

        Node(int number, String orders){
            this.number = number;
            this.orders = orders;
        }
    }

    static int orderD(int n){
        return (n*2)%10000;
    }

    static int orderS(int n){
        if(n-1 == -1) return 9999;
        return n-1;
    }

    static int orderL(int n){
        int a4 = n % 10;
        int a3 = (n-a4)%100/10;
        int a1 = n / 1000;
        int a2 = (n-a1*1000)/100;
        return a2*1000 + a3*100 + a4*10 + a1;
    }

    static int orderR(int n){
        int a4 = n % 10;
        int a3 = (n-a4)%100/10;
        int a1 = n / 1000;
        int a2 = (n-a1*1000)/100;
        return a4*1000 + a1*100 + a2*10 + a3;
    }

    static void setUsed(){
        Arrays.fill(used, false);
    }
}
