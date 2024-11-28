package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem13305 {
    static int N;
    static Node[] nodeInfo;
    static Stack<Node> stacks = new Stack<>();
    static long result;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        nodeInfo = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            nodeInfo[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st1.nextToken()));
        }
        stacks.add(nodeInfo[0]);
        for(int i = 1; i < N - 1; i++){
            if(stacks.peek().price < nodeInfo[i].price){
                stacks.peek().dist += nodeInfo[i].dist;
            }
            else{
                stacks.add(nodeInfo[i]);
            }
        }
        while(!stacks.isEmpty()){
            Node node = stacks.pop();
            result += node.dist * node.price;
        }
        System.out.println(result);
    }

    static class Node{
        long dist;
        int price;
        Node(long dist, int price){
            this.price = price;
            this.dist = dist;
        }
    }
}
