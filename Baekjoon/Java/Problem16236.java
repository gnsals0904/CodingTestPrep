import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16236 {
    static int N;
    // 원본 Graph
    static int[][] graph;
    // 거리 비교용 graph 겸 visited 체크도
    static int[][] visited;
    // new vector
    static int[][] vector = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int max_distance;
    static int fish_size;

    // bfs
    static Queue<Point> queue = new LinkedList<>();
    // result
    static int result;
    static BabyShark babyShark;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new int[N][N];
        // graph input
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
                if (graph[i][j] == 9) {
                    babyShark = new BabyShark(i, j, 2, 0);
                }
            }
        }
        find_fish();
    }

    // 물고기를 찾자
    static public void find_fish() {
        while (bfs()) {
            cal_result();
            setVisited();
        }
        System.out.println(result);
    }

    // bfs
    static public boolean bfs() {
        boolean flag = false;
        boolean flag2 = false;
        queue.add(new Point(babyShark.x, babyShark.y));
        visited[babyShark.x][babyShark.y] = 0;
        int time = -1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            time++;
            for (int a = 0; a < qSize; a++) {
                Point p = queue.poll();
                // 검사 수행 먼저 시작
                for (int[] v : vector) {
                    int nx = p.x + v[0];
                    int ny = p.y + v[1];
                    // map 밖으로 나가면 ㄴㄴ
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    // 나보다 큰 물고기는 노노
                    if (graph[nx][ny] > babyShark.size) {
                        continue;
                    }
                    // 방문안했다면 고
                    if (visited[nx][ny] == -1) {
                        visited[nx][ny] = time + 1;
                        queue.add(new Point(nx, ny));
                        // 먹을 수 있는 물고기면
                        if (graph[nx][ny] != 0 && graph[nx][ny] < babyShark.size) {
                            // 이거리 안에서 찾음
                            max_distance = visited[nx][ny];
                            fish_size = graph[nx][ny];
                            flag = true;
                            flag2 = true;
                        }
                    }
                }
            }
            if (flag2) {
                break;
            }
        }
        return flag;
    }

    // cal result
    static public void cal_result() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0 && visited[i][j] == max_distance && graph[i][j] < babyShark.size) {
                    // 먹는당
                    graph[i][j] = 9;
                    graph[babyShark.x][babyShark.y] = 0;
                    babyShark.eat_num++;
                    // 같으면 커진다
                    if (babyShark.size == babyShark.eat_num) {
                        babyShark.size++;
                        babyShark.eat_num = 0;
                    }
                    // 이동한다
                    babyShark.x = i;
                    babyShark.y = j;
                    result += visited[i][j];
                    return;
                }
            }
        }
    }

    // visited reset
    static public void setVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
            }
        }
        queue.clear();
    }

    static public class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static public class BabyShark {
        int x;
        int y;
        int size;
        int eat_num;

        BabyShark(int x, int y, int size, int eat_num) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat_num = eat_num;

        }
    }
}
