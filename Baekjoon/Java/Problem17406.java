package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [G4] 백준 17406 배열 돌리기 4
 * 메모리 : 14936 KB
 * 시간 : 236 ms
 * 코드 길이 : 6520 B
 * 아이디어 : 배열을 돌리는 함수를 만들고, 그거를 계속 재활용하면 될 것 같다. 근데 k 가 6개가 들어올 수 있으므로
 * 어떤 연산을 먼저 해줄지 모든 경우의 수를 구해서 해당 경우의 수일때 어떤 최솟값이 나오는지를 확인해야겠다.
 *
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/17406">
 *
 */
public class Problem17406 {
    // 원본 배열
    static int[][] arr;
    // copy 하고 사용할 임시 배열
    static int[][] temp_arr;
    // 배열의 크기 (N, M) 연산 횟수 K 을 입력받는다.
    static int N, M, K;
    // 회전 연산의 종류를 담을 배열
    static int[][] how_rotate;
    // 결과값을 저장할 변수
    static int min_result = Integer.MAX_VALUE;
    // 방향 벡터 (왼쪽, 아래쪽, 오른쪽, 위쪽) 반시계 방향 (저장하려면 반대로 가야한다)
    // 왼쪽으로 가면서 저장해야 결과적으로는 오른쪽으로 애들을 옮기는게 된다.
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    // 사용한 연산은 체크해주어야 한다.
    static boolean[] isused;
    // 경우의 수를 담을 배열
    static ArrayList<Integer> how = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 선언
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        // 한줄 입력받고 파싱
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열의 세로 길이
        N = Integer.parseInt(st.nextToken());
        // 배열의 가로 길이
        M = Integer.parseInt(st.nextToken());
        // 배열을 회전시킬 연산의 수
        K = Integer.parseInt(st.nextToken());
        // 배열 생성
        arr = new int[N][M];
        temp_arr = new int[N][M];
        // 한줄씩 배열의 요소 입력 받기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // temp arr 에서 -> arr 로 값 옮기기
        arr_2_temp();
        // K개의 연산 저장
        how_rotate = new int[K][3];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                how_rotate[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 사용한 연산은 체크하기 위해 생성
        isused = new boolean[K];

        // 재귀함수로 경우의 수를 탐색한다
        func(0);

        // 결과 출력
        System.out.println(min_result);
    }

    // 재귀함수로 경우의 수를 탐색한다
    static void func(int depth) {
        // 다 골랐으면
        if(depth == K) {
            // 어디기준으로 돌릴지 계산하고 그만큼 계산하자
            for(int h : how) {
                rotate(how_rotate[h][0], how_rotate[h][1], how_rotate[h][2]);
            }
            // 현재 경우의 수로 다 진행했다면 계산해보자
            int temp = calc_arr();
            // 계산 했으면 원본 배열로 돌려놓자
            arr_2_temp();
            // 최소값을 갱신하자
            if(temp < min_result) {
                min_result = temp;
            }
            return;
        }
        // 모든 경우의 수를 중복없이 고른다
        for(int i = 0; i < K; i++) {
            if(!isused[i]) {
                // 하나를 골랐으니 depth 증가
                depth++;
                // 해당 경우를 이미 골랐으니 false 로 변경
                isused[i] = true;
                // 해당 경우의 수를 리스트에 담아주고
                how.add(i);
                // 다음 경우의 수를 구하러 가자
                func(depth);
                // 재귀가 끝나면 초기화 해주어야한다.
                isused[i] = false;
                depth--;
                how.remove(how.size() - 1);
            }
        }
    }

        // 회전시키는 메서드
        static void rotate(int std_x, int std_y, int r) {
        // 실제 들어있는 값보다 1을 빼주어야 한다
        std_x--;
        std_y--;
        // 회전 시킬 layer 의 개수만큼  진행한다.
        for(int i = 1; i <= r; i++) {
            // sx, sy 는 배열 돌리기할 시작 기준 좌표이다
            int sx = std_x - i;
            int sy = std_y - i;
            int x = std_x - i;
            int y = std_y - i;
            // ex, ey 는 배열 돌리기 할때 방향 전환해주기 위해서 돌릴 배열의 최대 크기를 구하기 위해서 필요하다
            int ex = std_x + i;
            int ey = std_y + i;
            // 덮어씌워지기 전에 미리 저장
            int temp = temp_arr[x][y];
            int dir = 0; // (왼쪽, 아래쪽, 오른쪽, 위쪽) 반시계 방향으로 이동하며 반시계 방향으로 값 넣을 인덱스
            while(dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                // 한 방향으로 쭉 가면서 넣어주기
                if(nx <= ex && ny <= ey && nx >= sx && ny >= sy) {
                    temp_arr[x][y] = temp_arr[nx][ny];
                    x = nx;
                    y = ny;
                }
                // 범위를 벗어나면 방향 변경
                else {
                    dir++;
                }

            }
            temp_arr[sx][sy + 1] = temp; // 저장해놓은거 불러오기
        }
    }

    // 배열 복사하는 메서드 arr 를 temp arr 로 옮긴다.
    static void arr_2_temp() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                temp_arr[i][j] = arr[i][j];
            }
        }
    }

    // 현재 배열의 값 계산
    static int calc_arr() {
        // 문제의 조건에 맞춰서 현재 배열의 값을 계산하고 리턴해준다.
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int temp = 0;
            for(int j = 0; j < M; j++) {
                temp += temp_arr[i][j];
            }
            if(temp < result) {
                result = temp;
            }
        }
        return result;
    }
}

