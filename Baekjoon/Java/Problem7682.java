package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Problem7682 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			// 끝
			if(s.equals("end")) break;
			// board 입력 받기
			char[] board = new char[9];
			board = s.toCharArray();
			int[] num = new int[2];
			// X O 개수 세기
			num = countXO(board);
			
			// 둘의 차이는 1 이상 날 수 없다
			if(Math.abs(num[0] - num[1]) > 1) {
				sb.append("invalid").append("\n");
				continue;
			}
			// O의 개수가 X보다 많을 수 없다
			if(num[0] > num[1]) {
				sb.append("invalid").append("\n");
				continue;
			}
			// 누가 이겼는지?
			char whoWin = whoWin(board);

			
			// 둘다 이긴경우는 말이 안된다
			if(whoWin == 'N') {
				sb.append("invalid").append("\n");
			}
			// 아무도 못이긴 경우
			else if(whoWin == 'Y') {
				// 게임판이 꽉 차있으면 valid
				if(fullboard(board)) {
					sb.append("valid").append("\n");
				}
				// 아직 더 놓을 수 있으면 더 진행해야한다
				else {
					sb.append("invalid").append("\n");
				}
			}
			// X 가 이긴경우
			else if(whoWin == 'X') {
				// X가 이겼을때 X의 개수가 더 많아야한다
				if(num[0] < num[1]) {
					sb.append("valid").append("\n");
				} else {
					sb.append("invalid").append("\n");
				}
			}
			// O 가 이긴경우
			else if(whoWin == 'O') {
				// 이 경우에 X와 O는 수가 같아야 한다
				if(num[0] == num[1]) {
					sb.append("valid").append("\n");
				}
				else {
					sb.append("invalid").append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	// 게임판을 다 채웠는지?
	static boolean fullboard(char[] board) {
		for(int i = 0; i < 9; i++) {
			if(board[i] == '.') return false;
		}
		return true;
	}
	
	// O X 개수 세기
	// 0 => O 개수
	// 1 => X 개수
	static int[] countXO(char[] board) {
		int[] temp = new int[2];
		Arrays.fill(temp, 0);
		for(int i = 0; i < 9; i++) {
			if(board[i] == 'X') temp[1]++;
			else if(board[i] == 'O') temp[0]++;
		}
		return temp;
	}
	
	// 누가 이겼는지?
	static char whoWin(char[] board) {
		boolean X = false;
		boolean O = false;
		for(int i = 0; i < 9; i+=3) {
			// 가로줄 체크
			if(sameAll(board[i], board[i + 1], board[i + 2])) {
				if(board[i] == 'X') X = true;
				else if(board[i] == 'O') O = true;
			}
		}
		for(int i = 0; i < 3; i++) {
			// 세로줄 체크
			if(sameAll(board[i], board[i + 3], board[i + 6])) {
				if(board[i] == 'X') X = true;
				else if(board[i] == 'O') O = true;
			}
		}
		// \ 방향 대각선 체크
		if(sameAll(board[0], board[4], board[8])) {
			if(board[0] == 'X') X = true;
			else if(board[0] == 'O') O = true;
		}
		// / 방향 대각선 체크
		if(sameAll(board[2], board[4], board[6])) {
			if(board[2] == 'X') X = true;
			else if(board[2] == 'O') O = true;
		}
		// 둘 다 이긴경우 => invalid
		if(X && O) {
			return 'N';
		}
		// X가 이긴경우
		else if(X) {
			return 'X';
		}
		// O가 이긴경우
		else if(O) {
			return 'O';
		}
		// 아무도 못 이긴 경우
		else {
			return 'Y';
		}
	}
	
	// 세 값이 같은지?
	static boolean sameAll(char c1, char c2, char c3) {
		if(c1 == c2 && c1 == c3 && c2 == c3) return true;
		else return false;
	}

}
