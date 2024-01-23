package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2263 {
    static StringBuilder sb = new StringBuilder();
    static int[] inorder, postorder;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        preorder(0, n - 1, 0, n -1);

        System.out.println(sb.toString());
    }
    static void preorder(int is, int ie, int ps, int pe){
        if (ps > pe || is > ie) {
            return;
        }

        // inorder 에서의 root idx search
        int root = postorder[pe];
        int rootIdx = 0;
        for(int i = is; i < ie + 1; i++){
            if (root == inorder[i]) {
                rootIdx = i;
                break;
            }
        }
        sb.append(root);
        sb.append(" ");
        int len = rootIdx - is;
        // left
        preorder(is, is + len - 1, ps, ps + len - 1);
        // right
        preorder(is + len + 1, ie, ps + len, pe - 1);
    }
}
