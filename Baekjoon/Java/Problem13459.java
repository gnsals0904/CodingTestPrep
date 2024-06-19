import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] graph;
    static char[][] realGraph;
    static int N, M;
    static Point hole;
    static Ball realRedBall, realBlueBall;
    static Ball redBall, blueBall;
    // 상 하 좌 우
    static int[][] vector = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] nowNum = new int[10];
    static boolean redSuccess, blueSuccess;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        realGraph = new char[N][M];
        for(int i = 0; i < N; i++){
            graph[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                realGraph[i][j] = graph[i][j];
                if(graph[i][j] == 'R') redBall = new Ball(i, j);
                else if(graph[i][j] == 'B') blueBall = new Ball(i, j);
                else if(graph[i][j] == 'O') hole = new Ball(i, j);
            }
        }
        realRedBall = new Ball(redBall.x, redBall.y);
        realBlueBall = new Ball(blueBall.x, blueBall.y);
        int all = (int) Math.pow(4, 10);
        for(int i = 0; i < all; i++){
            calcNum(i);
            for(int num : nowNum){
                // red first
                if(whoFirst(num)){
                    int nx = redBall.x;
                    int ny = redBall.y;
                    while (true){
                        nx += vector[num][0];
                        ny += vector[num][1];
                        if(graph[nx][ny] == 'O') {
                            redSuccess = true;
                            graph[redBall.x][redBall.y] = '.';
                            break;
                        }
                        else if(graph[nx][ny] != '.'){
                            nx -= vector[num][0];
                            ny -= vector[num][1];
                            graph[redBall.x][redBall.y] = '.';
                            redBall.x = nx;
                            redBall.y = ny;
                            graph[redBall.x][redBall.y] = 'R';
                            break;
                        }
                    }
                    nx = blueBall.x;
                    ny = blueBall.y;
                    while (true){
                        nx += vector[num][0];
                        ny += vector[num][1];
                        if(graph[nx][ny] == 'O') {
                            blueSuccess = true;
                            graph[blueBall.x][blueBall.y] = '.';
                            break;
                        }
                        else if(graph[nx][ny] != '.'){
                            nx -= vector[num][0];
                            ny -= vector[num][1];
                            graph[blueBall.x][blueBall.y] = '.';
                            blueBall.x = nx;
                            blueBall.y = ny;
                            graph[blueBall.x][blueBall.y] = 'B';
                            break;
                        }
                    }
                }
                // blue first
                else{
                    int nx = blueBall.x;
                    int ny = blueBall.y;
                    while (true){
                        nx += vector[num][0];
                        ny += vector[num][1];
                        if(graph[nx][ny] == 'O') {
                            blueSuccess = true;
                            graph[blueBall.x][blueBall.y] = '.';
                            break;
                        }
                        else if(graph[nx][ny] != '.'){
                            nx -= vector[num][0];
                            ny -= vector[num][1];
                            graph[blueBall.x][blueBall.y] = '.';
                            blueBall.x = nx;
                            blueBall.y = ny;
                            graph[blueBall.x][blueBall.y] = 'B';
                            break;
                        }
                    }
                    nx = redBall.x;
                    ny = redBall.y;
                    while (true){
                        nx += vector[num][0];
                        ny += vector[num][1];
                        if(graph[nx][ny] == 'O') {
                            redSuccess = true;
                            graph[redBall.x][redBall.y] = '.';
                            break;
                        }
                        else if(graph[nx][ny] != '.'){
                            nx -= vector[num][0];
                            ny -= vector[num][1];
                            graph[redBall.x][redBall.y] = '.';
                            redBall.x = nx;
                            redBall.y = ny;
                            graph[redBall.x][redBall.y] = 'R';
                            break;
                        }
                    }
                }
            }
            if(redSuccess && !blueSuccess){
                System.out.println(1);
                return;
            }
            setInit();
        }
        System.out.println(0);
    }

    // true => red, false => blue
    static boolean whoFirst(int dir){
        if(dir == 0){
            return redBall.x < blueBall.x;
        } else if(dir == 1){
            return redBall.x > blueBall.x;
        } else if(dir == 2){
            return redBall.y < blueBall.y;
        } else {
            return redBall.y > blueBall.y;
        }
    }

    static void calcNum(int n){
        int temp = n;
        for(int i = 0; i < 10; i++){
            nowNum[i] = temp % 4;
            temp = temp / 4;
        }
    }

    static void setInit(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                graph[i][j] = realGraph[i][j];
            }
        }
        redBall.x = realRedBall.x;
        redBall.y = realRedBall.y;
        blueBall.x = realBlueBall.x;
        blueBall.y = realBlueBall.y;
        redSuccess = false;
        blueSuccess = false;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Ball extends Point{
        Ball(int x, int y) {
            super(x, y);
        }
    }
}
