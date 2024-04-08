package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S1] BJ 20529 가장 가까운 세 사람의 심리적 거리
 * 메모리 : 23544 KB
 * 시간 : 216 ms
 * 코드 길이 : 1428	 B
 * 아이디어 : MBTI의 종류는 총 16가지이므로, 33개이상의 입력이 들어오면 같은 MBTI를 가진 사람은 무조건 3명이상이 된다. 즉 무조건 답은 0이다.
 * 만약 33개 이하라면 완전탐색을 통해서 답을 구해주면 된다.
 * 
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/20529">
 *
 */
public class Problem20529 {
	// 결과 저장
	static int result;
	public static void main(String[] args) throws IOException {
		// 입력받기
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			// 입력받기
			result = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			String[] s = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				s[i] = st.nextToken();
			}
			// 결과 출력
			// 33개 이상의 입력 => 무조건 0 
			if(N >= 33) sb.append(0).append("\n");
			// 그게 아니면 완전탐색
			else sb.append(calc(s)).append("\n");
		}
		System.out.println(sb);
	}
	
	// 3명을 골라서 그들의 거리를 계산한다
	static int calc(String[] s) {
		for(int i = 0; i < s.length; i++) {
			for(int j = i + 1; j < s.length; j++) {
				for(int k = j + 1; k < s.length; k++) {
					int temp = dist(s[i], s[j], s[k]);
					result = Math.min(result, temp);
				}
			}
		}
		return result;
	}
	
	// 거리를 계산한다
	static int dist(String s1, String s2, String s3) {
		int result = 0;
		for(int i = 0; i < 4; i++) {
			if(s1.charAt(i) != s2.charAt(i)) result++;
		}
		for(int i = 0; i < 4; i++) {
			if(s2.charAt(i) != s3.charAt(i)) result++;
		}
		for(int i = 0; i < 4; i++) {
			if(s3.charAt(i) != s1.charAt(i)) result++;
		}
		return result;
	}
}
