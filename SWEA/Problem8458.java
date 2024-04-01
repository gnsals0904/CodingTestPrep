package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [D4] 원점으로 집합
 * 메모리 : 39,972 KB
 * 시간 : 189 ms
 * 코드 길이 : 1,614 B
 * 아이디어 : 맨해튼 거리를 이용해서 거리를 모두 구해준 다음에, 그 거리가 모두 짝수이거나 홀수가 아니면 -1 을 출력하고
 * 가장 먼 거리의 점이 원점에 도달하는 순간 종료되기 때문에, 매 초 이동량의 누적값을 구한 다음 해당 값이 가장 먼 거리의 점보다 크면서 그 차이가 짝수이면 종료하면 된다.
 *
 * @author 김훈민
 * @see <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWzaq5KKk_ADFAVU">
 *
 */
public class Problem8458 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase = 1; testcase <= T; testcase++) {
			// 입력 받기
			int N = Integer.parseInt(br.readLine());
			// 맨하튼 거리로 거리를 구한다
			int[] sum_arr = new int[N];
			// 가장 먼 거리의 점의 거리 값을 저장한다.
			int max_num = Integer.MIN_VALUE;
			// 입력받기
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				sum_arr[i] = Math.abs(x) + Math.abs(y);
				if(max_num < sum_arr[i]) {
					max_num = sum_arr[i];
				}
			}
			int odd_num = 0;
			int even_num = 0;
			// 짝수와 홀수의 개수가 각각 몇개인지 확인한다.
			for(int i = 0; i < N; i++) {
				if(sum_arr[i] % 2 == 0) {
					even_num++;
				}
				else {
					odd_num++;
				}
			}
			
			// 홀수 & 짝수가 섞여 있으면 원점으로 이동시킬 수 없다
			if(odd_num != 0 && even_num != 0) {
				sb.append("#").append(testcase).append(" ").append(-1).append("\n");
				continue;
			}
			
			int moveCount = 0;
			int i = 0;
			while(true) {
				moveCount += i;
				// 매 초 이동량의 누적값을 구한 다음 해당 값이 가장 먼 거리의 점보다 크면서 그 차이가 짝수이면 종료
				if(moveCount >= max_num && (moveCount - max_num) % 2 == 0) {
					break;
				}
				i++;
			}
			sb.append("#").append(testcase).append(" ").append(i).append("\n");
		}
		System.out.println(sb);
	}

}
