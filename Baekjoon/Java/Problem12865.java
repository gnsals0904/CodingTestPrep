import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12865 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 선언
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        // 한줄 입력받고 파싱
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정보 수와 최대 무게를 입력받는다
        // 물건의 정보 수
        int N;
        // 최대 들 수 있는 무게 제한
        int K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] info = new int[N + 1][2];
        info[0][0] = 0;
        info[0][1] = 0;
        // 정보를 입력받아서 저장한다
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            // 무게 => 0 , 가치 => 1
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        // dp 로 계산하기 위해 테이블 생성
        int[][] dp = new int[K + 1][N + 1];
        dp[0][0] = 0;
        // dp 0은 0으로 초기화
        for(int i = 0; i < K + 1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < N + 1; i++){
            dp[0][i] = 0;
        }
        // i 는 무게를 의미
        for(int i = 1; i < K + 1; i++){
            // j 는 물건의 순서 정보
            for(int j = 1; j < N + 1; j++){
                // 애초에 물건을 가방에 못넣음
                if(info[j][0] > i){
                    dp[i][j] = dp[i][j - 1];
                }
                // 물건을 가방에 넣을 수 있으면
                else{
                    // 해당 물건을 안넣은 경우와 해당 물건을 넣은 경우 중 더 큰값으로 갱신
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - info[j][0]][j - 1] + info[j][1]);
                }
            }
        }
        // 결과 출력
        System.out.printf("%d\n", dp[K][N]);
    }
}

