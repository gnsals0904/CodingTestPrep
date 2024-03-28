package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [G4] BJ 3055 탈출
 * 메모리 : 16816 KB
 * 시간 : 180 ms
 * 코드 길이 : 6622 B
 * 아이디어 : bfs를 두번 돌려서 물이 언제차는지 시간을 기록한다음, 그 시간보다 먼저 비버가 이동할 수 있는 경우에만 비버를 이동시킨다.
 * 
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/12015">
 *
 */
public class Problem3055 {
    // graph 는 문자로 들어오지만 굳이 문자로 저장할 필요 없으므로 int 로 저장
    static int[][] graph;
    // graph 의 크기
    static int R, C;
    // 비버의 굴이 목적지이므로 저장한다.
    static int e_x, e_y;
    // 출발지를 저장하자.
    static int s_x, s_y;
    // bfs 를 진행하기위해 큐 선언
    static Queue<Point> queue = new LinkedList<>();
    // 방향 벡터
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // graph 의 크기를 입력 받는다
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new int[R][C];
        // graph 정보를 입력받는다
        for(int i = 0; i < R; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < C; j++){
                int tmp = what_is(temp[j]);
                // 목적지를 기록한다
                if(tmp == 252){
                    e_x = i;
                    e_y = j;
                }
                // 출발지를 기록한다
                else if(tmp == -2){
                    s_x = i;
                    s_y = j;
                }
                // 물이면 그 좌표를 큐에다가 넣자
                else if(tmp == 0){
                    queue.add(new Point(i, j));
                }
                // 그리고 일단 그래프에 기록하자
                graph[i][j] = tmp;
            }
        }
        // 큐에 있는 물의 좌표로 bfs 를 돌리며 물이 언제 그 위치로 가는지 그래프에 숫자로 기록한다.
        bfs1();
        // 고슴도치의 좌표는 다시 0으로 초기화해준다.
        graph[s_x][s_y] = 0;
        // 이제 고슴도치가 비버의 굴로 가야하므로 큐에 넣어준다
        queue.add(new Point(s_x, s_y));
        // 과연 고슴도치는 비버의 굴로 갈수있을까?
        bfs2();
        // 여기까지 오면 도착을 못한것이다.
        System.out.println("KAKTUS");

    }

    // 물의 bfs
    static void bfs1(){
        // 큐가 비어있지 않으면 진행
        while(!queue.isEmpty()){
            // 큐에서 하나 빼고
            Point p = queue.poll();
            // 다음 좌표로 진행한다
            for(int[] v : vector){
                // 다음 진행할 좌표
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                // 맵 밖으로 나가면 안돼
                if(nx < 0 || ny < 0 || nx >= R || ny >= C){
                    continue;
                }
                // 돌로는 갈 수 없다
                if(graph[nx][ny] == -1){
                    continue;
                }
                // 비버의 굴을 덮칠 수 없다
                if(graph[nx][ny] == 252){
                    continue;
                }
                // 내 현재 값 + 1 보다 작거나 같으면 이미 물이 덮친 상황이니 또 덮어씌울 필요는 없다
                if(graph[nx][ny] <= graph[p.x][p.y] + 1){
                    continue;
                }
                // 나보다 큰 값이라면 작은 값으로 갱신해준다.
                graph[nx][ny] = graph[p.x][p.y] + 1;
                // 다음 bfs 진행한다
                queue.add(new Point(nx, ny));
            }
        }
    }

    // 고슴도치의 bfs
    static void bfs2(){
        // 큐가 비어있지 않으면 진행
        while(!queue.isEmpty()){
            // 큐에서 하나 빼고
            Point p = queue.poll();
            // 목적지에 도착하면
            if(p.x == e_x && p.y == e_y){
                // 몇초걸렸는지 출력하고 그냥 끝내버리기
                System.out.println(graph[p.x][p.y]);
                System.exit(0);
            }
            // 다음 좌표로 진행한다
            for(int[] v : vector){
                // 다음 진행할 좌표
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                // 맵 밖으로 나가면 안돼
                if(nx < 0 || ny < 0 || nx >= R || ny >= C){
                    continue;
                }
                // 돌로는 갈 수 없다
                if(graph[nx][ny] == -1){
                    continue;
                }
                // 나보다 작은 값이면 이미 물이 덮쳐버린거니까 갈수없다
                if(graph[nx][ny] <= graph[p.x][p.y] + 1){
                    continue;
                }
                // 나보다 큰 값이라면 작은 값으로 갱신해주며 진행한다.
                graph[nx][ny] = graph[p.x][p.y] + 1;
                // 다음 bfs 진행한다
                queue.add(new Point(nx, ny));
            }
        }
    }

    // 들어온 문자를 숫자로 치환해서 리턴해준다.
    static int what_is(String s){
        // .은 일단 갈수있는 곳이므로 큰 숫자로 치환
        switch (s) {
            case ".":
                return 251;

            // 목적지 이므로 252로 리턴
            case "D":
                return 252;

            // 출발지 이므로 -2로 치환
            case "S":
                return -2;

            // 돌로는 갈 수 없다 -1로 치환
            case "X":
                return -1;

            // 나머지 경우는 물인 경우이다
            default:
                return 0;
        }
    }

    // x y 좌표를 이용하기 위해 point 클래스 선언
    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
