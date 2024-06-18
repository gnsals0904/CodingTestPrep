package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14890 {
    static int[][] graph;
    static int N, L;
    static boolean[][] canUseVertical;
    static boolean[][] canUseHorizon;
    static Queue<Point> queue = new LinkedList<>();
    static int result;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        canUseVertical = new boolean[N][N];
        canUseHorizon = new boolean[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            checkVerticalLine(0, i);
            checkHorizonLine(i, 0);
        }
        for(int i = 0; i < N; i++){
            if (canGoVertical(0, i)) result++;
            if (canGoHorizon(i, 0))  result++;
        }
        System.out.println(result);
    }

    static boolean canGoVertical(int x, int y){
        int preValue = graph[x][y];
        x = x + 1;
        while(x < N){
            if(preValue != graph[x][y]){
                // down
                if(preValue - graph[x][y] == 1){
                    if(!canInstall(x, y, 1)) return false;
                }
                // up
                else if (preValue - graph[x][y] == -1){
                    if(!canInstall(x - 1, y, 0)) return false;
                }
                else return false;
            }
            preValue = graph[x][y];
            x++;
        }
        return true;
    }

    static boolean canGoHorizon(int x, int y){
        int preValue = graph[x][y];
        y = y + 1;
        while(y < N){
            if(preValue != graph[x][y]){
                // down
                if(preValue - graph[x][y] == 1){
                    if(!canInstall(x, y, 3)) return false;
                }
                // up
                else if (preValue - graph[x][y] == -1){
                    if(!canInstall(x, y - 1, 2)) return false;
                }
                else return false;
            }
            preValue = graph[x][y];
            y++;
        }
        return true;
    }

    static boolean canInstall(int x, int y, int dir){
        int count = 0;
        // up -> down
        if(dir == 0){
            while(count != L){
                if(x >= 0 && canUseVertical[x][y]){
                    queue.add(new Point(x, y));
                }
                else return false;
                x--;
                count++;
            }
            while (!queue.isEmpty()){
                Point p = queue.poll();
                canUseVertical[p.x][p.y] = false;
            }
        }
        // down -> up
        else if(dir == 1) {
            while(count != L){
                if(x < N && canUseVertical[x][y]){
                    queue.add(new Point(x, y));
                }
                else return false;
                x++;
                count++;
            }
            while (!queue.isEmpty()){
                Point p = queue.poll();
                canUseVertical[p.x][p.y] = false;
            }
        }
        // up -> left
        else if(dir == 2){
            while(count != L){
                if(y >= 0 && canUseHorizon[x][y]){
                    queue.add(new Point(x, y));
                }
                else return false;
                y--;
                count++;
            }
            while (!queue.isEmpty()){
                Point p = queue.poll();
                canUseHorizon[p.x][p.y] = false;
            }
        }
        // down -> right
        else{
            while(count != L){
                if(y < N && canUseHorizon[x][y]){
                    queue.add(new Point(x, y));
                }
                else return false;
                y++;
                count++;
            }
            while (!queue.isEmpty()){
                Point p = queue.poll();
                canUseHorizon[p.x][p.y] = false;
            }
        }
        return true;
    }

    static void checkVerticalLine(int x, int y){
        int preValue = graph[x][y];
        queue.add(new Point(x, y));
        x = x + 1;
        while(x < N){
            if(preValue != graph[x][y]){
                if(queue.size() >= L){
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        canUseVertical[p.x][p.y] = true;
                    }
                }
                else queue.clear();
            }
            queue.add(new Point(x, y));
            preValue = graph[x][y];
            x = x + 1;
        }
        if(queue.size() >= L){
            while(!queue.isEmpty()){
                Point p = queue.poll();
                canUseVertical[p.x][p.y] = true;
            }
        }
        else queue.clear();
    }

    static void checkHorizonLine(int x, int y){
        int preValue = graph[x][y];
        queue.add(new Point(x, y));
        y = y + 1;
        while(y < N){
            if(preValue != graph[x][y]){
                if(queue.size() >= L){
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        canUseHorizon[p.x][p.y] = true;
                    }
                }
                else queue.clear();
            }
            queue.add(new Point(x, y));
            preValue = graph[x][y];
            y = y + 1;
        }
        if(queue.size() >= L){
            while(!queue.isEmpty()){
                Point p = queue.poll();
                canUseHorizon[p.x][p.y] = true;
            }
        }
        else queue.clear();
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
