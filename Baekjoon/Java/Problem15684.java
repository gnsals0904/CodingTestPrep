package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15684 {
	static boolean[][] ladder;
	static boolean[][] temp_ladder;
	static int N;
	static int M;
	static int H;

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N => 세로선 / M => 가로선 / H => 가로선
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		// 초기 세팅
		int a, b;
		ladder = new boolean[H][N - 1];
		temp_ladder = new boolean[H][N - 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ladder[a - 1][b - 1] = true;
			temp_ladder[a - 1][b - 1] = true;
		}
		if (valid()) {
			System.out.println(0);
		} else if (put_ladder_1()) {
			System.out.println(1);
		} else if (put_ladder_2()) {
			System.out.println(2);
		} else if (put_ladder_3()) {
			System.out.println(3);
		} else {
			System.out.println(-1);
		}

	}

	// 현재 놓은 사다리의 개수가 짝수개가 있는지 확인하는 메서드
	static boolean is_even() {
		// 각 라인의 사다리가 가로로 짝수개가 있어야 돌아갈 수 있다.
		for (int i = 0; i < N - 1; i++) {
			int count = 0;
			for (int j = 0; j < H; j++) {
				if (temp_ladder[j][i]) {
					count++;
				}
			}
			if (count % 2 == 1) {
				return false;
			}
		}
		return true;
	}

	// 각 사다리 출발시 자기 자리로 돌아갔는지 확인하는 메서드
	static boolean im_back(int idx) {
		// 어느 세로선에서 출발했는지 저장한다.
		int s_idx = idx;
		// 출발은 0 에서 시작한다
		int now_x = 0;
		// 도착지까지 내려본다
		while (now_x != H) {
			// 맨 왼쪽일 경우 오른쪽만 확인해주면 된다.
			if (idx == 0) {
				// true 면 오른쪽으로 가기위해서 idx 를 증가시킨다
				if (temp_ladder[now_x][idx]) {
					now_x++;
					idx++;
				}
				// false 면 그냥 아래로 내려간다.
				else {
					now_x++;
				}
			}
			// 맨 오른쪽 경우 왼쪽만 확인해준다.
			else if (idx == N - 1) {
				// true 면 왼쪽으로 간다
				if (temp_ladder[now_x][idx - 1]) {
					idx--;
					now_x++;
				}
				// false 면 아래로 내려간다
				else {
					now_x++;
				}
			}
			// 나머지 경우
			else {
				// 양쪽 확인
				// 왼쪽으로 가는경우
				if (temp_ladder[now_x][idx - 1]) {
					idx--;
					now_x++;
				}
				// 오른쪽으로 가는 경우
				else if (temp_ladder[now_x][idx]) {
					now_x++;
					idx++;
				}
				// 둘다 아니면 그냥 내려가기
				else {
					now_x++;
				}
			}
		}
		// 만약 초기 i 랑 다르면 false
		if (s_idx != idx) {
			return false;
		}
		// 같으면 true
		else {
			return true;
		}
	}

	// 현재 놓은 사다리가 괜찮은지 확인하는 메서드
	static boolean valid() {
		// 각 라인의 사다리가 가로로 짝수개가 있어야 돌아갈 수 있다.
		// 짝수개가 아니라면 false 를 출력한다.
		if (!is_even()) {
			return false;
		}
		// 일단 전체 짝수긴 하니 한번 돌려보자
		for (int i = 0; i < N; i++) {
			if (!im_back(i)) {
				return false;
			}
		}
		// 여기까지 왔다면 다 올바르게 내려간 것.
		return true;
	}

	// 현재 위치에 사다리를 놓을 수 있는지 체크한다
	static boolean can_put(int x, int y) {
		// 이미 놓여있는 경우, 놓을 수 없다
		if (temp_ladder[x][y]) {
			return false;
		}
		// 옆에 사다리가 이미 놓아져있으면 놓을 수 없음
		// 왼쪽 확인
		if (y - 1 >= 0) {
			if (temp_ladder[x][y - 1]) {
				return false;
			}
		}
		// 오른쪽 확인
		if (y + 1 < N - 1) {
			if (temp_ladder[x][y + 1]) {
				return false;
			}
		}
		// 모든 경우가 아니라면 놓을 수 있다
		return true;
	}

	// 사다리를 1개 놓는 경우
	static boolean put_ladder_1() {
		int x1, y1;
		for (int i = 0; i < (N - 1) * H; i++) {
			// 경우의 수에 따른 사다리 놓는 x y 좌표
			x1 = i / (N - 1);
			y1 = i % (N - 1);
			// 놓을 수 없다면 다음 경우의 수 진행
			if(!can_put(x1, y1)) {
				continue;
			}
			// 사다리를 해당 위치에 놓고
			temp_ladder[x1][y1] = true;
			// 전부 제대로 내려가는지 확인
			if (valid()) {
				return true;
			}
			// 사다리 되돌리기
			temp_ladder[x1][y1] = false;
		}
		// 모든 경우의 수를 진행했지만 valid 하지 않으면 false
		return false;
	}

	static boolean put_ladder_2() {
		int x1, y1, x2, y2;
		// 사다리 2개 놓는 경우
		// 1번째 사다리 놓기
		for (int i = 0; i < (N - 1) * H; i++) {
			// 경우의 수에 따른 사다리 놓는 x y 좌표
			x1 = i / (N - 1);
			y1 = i % (N - 1);
			// 놓을 수 없다면 다음 경우의 수 진행
			if(!can_put(x1, y1)) {
				continue;
			}
			// 놓고
			temp_ladder[x1][y1] = true;
			// 다음 사다리 놓기
			for (int j = i + 1; j < (N - 1) * H; j++) {
				x2 = j / (N - 1);
				y2 = j % (N - 1);
				if (temp_ladder[x2][y2])
					continue;
				// 놓을 수 없다면 다음 경우의 수 진행
				if(!can_put(x2, y2)) {
					continue;
				}
				temp_ladder[x2][y2] = true;
				if (valid()) {
					return true;
				}
				// 사다리 되돌리기
				temp_ladder[x2][y2] = false;
			}
			temp_ladder[x1][y1] = false;
		}
		// 모든 경우의 수를 진행했지만 valid 하지 않으면 false
		return false;
	}
	// 사다리 3개 놓는 경우
	static boolean put_ladder_3() {
		int x1, y1, x2, y2, x3, y3;
		// 1번째 사다리 놓기
		for (int i = 0; i < (N - 1) * H; i++) {
			// 경우의 수에 따른 사다리 놓는 x y 좌표
			x1 = i / (N - 1);
			y1 = i % (N - 1);
			// 놓을 수 없다면 다음 경우의 수 진행
			if(!can_put(x1, y1)) {
				continue;
			}
			temp_ladder[x1][y1] = true;
			// 2번재 사다리 놓기
			for (int j = i + 1; j < (N - 1) * H; j++) {
				x2 = j / (N - 1);
				y2 = j % (N - 1);
				// 놓을 수 없다면 다음 경우의 수 진행
				if(!can_put(x2, y2)) {
					continue;
				}
				temp_ladder[x2][y2] = true;
				// 3번째 사다리 놓기
				for (int k = j + 1; k < (N - 1) * H; k++) {
					x3 = k / (N - 1);
					y3 = k % (N - 1);
					// 놓을 수 없다면 다음 경우의 수 진행
					if(!can_put(x3, y3)) {
						continue;
					}
					// 놓고
					temp_ladder[x3][y3] = true;
					if (valid()) {
						return true;
					}
					// 사다리 되돌리기
					temp_ladder[x3][y3] = false;
				}
				temp_ladder[x2][y2] = false;
			}
			temp_ladder[x1][y1] = false;
		}
		return false;
	}

	// 배열 출력하기
	static void print_arr(String s) {
		System.out.println("ㅡㅡㅡ" + s + "ㅡㅡㅡ");
		for (int l = 0; l < H; l++) {
			System.out.println(Arrays.toString(temp_ladder[l]));
		}
	}
}
