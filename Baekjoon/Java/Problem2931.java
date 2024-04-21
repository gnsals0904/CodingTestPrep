package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2931 {
    static int R, C;
    static char[][] graph;
    // 하, 상, 우, 좌
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        for(int i = 0; i < R; i++){
            graph[i] = br.readLine().toCharArray();
        }
        // 찾기
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(graph[i][j] == '.'){
                    if (check(i, j)){
                        return;
                    }
                }
            }
        }
    }

    static boolean check(int x, int y){
        // 하, 상, 우, 좌
        Point down_p = new Point(x + vector[0][0], y + vector[0][1]);
        Point up_p = new Point(x + vector[1][0], y + vector[1][1]);
        Point right_p = new Point(x + vector[2][0], y + vector[2][1]);
        Point left_p = new Point(x + vector[3][0], y + vector[3][1]);
        boolean[] chk = new boolean[4];
        // 아래에서 나한테 오는경우
        if(isIn(down_p.x, down_p.y) && canComeTop(graph[down_p.x][down_p.y])){
            chk[0] = true;
        }
        // 위에서 나한테 오는경우
        if(isIn(up_p.x, up_p.y) && canComeDown(graph[up_p.x][up_p.y])){
            chk[1] = true;
        }
        // 오른쪽에서 나한테 오는경우
        if(isIn(right_p.x, right_p.y) && canComeLeft(graph[right_p.x][right_p.y])){
            chk[2] = true;
        }
        // 왼쪽에서 나한테 오는 경우
        if(isIn(left_p.x, left_p.y) && canComeRight(graph[left_p.x][left_p.y])){
            chk[3] = true;
        }

        // + 가능
        if(chk[0] && chk[1] && chk[2] && chk[3]){
            System.out.println((x+1) + " " + (y+1) + " +");
        }
        // | 가능
        else if(chk[0] && chk[1] && !chk[2] && !chk[3]){
            System.out.println((x+1) + " " + (y+1) + " |");
        }
        // _ㅣ 가능
        else if(!chk[0] && chk[1] && !chk[2] && chk[3]){
            System.out.println((x+1) + " " + (y+1) + " 3");
        }
        // ㄴ 가능
        else if(!chk[0] && chk[1] && chk[2] && !chk[3]){
            System.out.println((x+1) + " " + (y+1) + " 2");
        }
        // ㄱ 가능
        else if(chk[0] && !chk[1] && !chk[2] && chk[3]){
            System.out.println((x+1) + " " + (y+1) + " 4");
        }
        // |^- 가능
        else if(chk[0] && !chk[1] && chk[2] && !chk[3]){
            System.out.println((x+1) + " " + (y+1) + " 1");
        }
        // - 가능
        else if(!chk[0] && !chk[1] && chk[2] && chk[3]){
            System.out.println((x+1) + " " + (y+1) + " -");
        }
        else{
            return false;
        }
        return true;
    }

    static boolean canComeTop(char c){
        if(c == '|' || c == '+' || c == '2' || c == '3') return true;
        return false;
    }
    // 1 = |-, 2 = ㄴ, 3 = _|, 4 = ㄱ
    static boolean canComeDown(char c){
        if(c == '|' || c == '+' || c == '1' || c == '4') return true;
        return false;
    }

    static boolean canComeLeft(char c){
        if(c == '-' || c == '+' || c == '3' || c == '4') return true;
        return false;
    }

    static boolean canComeRight(char c){
        if(c == '-' || c == '+' || c == '1' || c == '2') return true;
        return false;
    }

    static boolean isIn(int x, int y){
        if(x < 0 || x >= R || y < 0 || y >= C) return false;
        return true;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
